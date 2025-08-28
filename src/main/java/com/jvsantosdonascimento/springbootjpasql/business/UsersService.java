package com.jvsantosdonascimento.springbootjpasql.business;

import com.jvsantosdonascimento.springbootjpasql.business.mapper.IUsersMapper;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.UserRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.UserRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.repositories.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
}
