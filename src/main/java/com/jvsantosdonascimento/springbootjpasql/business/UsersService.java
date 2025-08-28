package com.jvsantosdonascimento.springbootjpasql.business;

import com.jvsantosdonascimento.springbootjpasql.business.mapper.IUsersMapper;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.UserRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.UserRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Users;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.repositories.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository repository;
    private final IUsersMapper usersMapper;

    public List<UserRecordOut> findAll() {
        return repository.findAll().stream()
                .map(usersMapper::fromOut)
                .toList();
    }
    public UserRecordOut findById(Long id) {
        return usersMapper.fromOut(repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Id: " + id +" not found")));
    }
    @Transactional
    public UserRecordOut insert(UserRecord user) {
        return usersMapper.fromOut(repository.save(usersMapper.fromEntity(user)));
    }
    @Transactional
    public void delete(Long id) {
        var user = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Id: " + id + " Not found"));
        repository.delete(user);
    }
    @Transactional
    public UserRecordOut update(Long id, UserRecord userRecord) {
        var data = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Id: " + id + " Not found"));
        return usersMapper.fromOut(repository.save(Users.builder().id(data.getId())
                .name(userRecord.name() != null ? userRecord.name() : data.getName())
                .email(userRecord.email() != null ? userRecord.email() : data.getEmail())
                .phone(userRecord.phone() != null ? userRecord.phone() : data.getPhone())
                .password(userRecord.password() != null ? new BCryptPasswordEncoder().encode(userRecord.password()) : data.getPassword())
                .build()));
    }
}
