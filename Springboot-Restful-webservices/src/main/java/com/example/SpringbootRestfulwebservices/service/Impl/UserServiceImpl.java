package com.example.SpringbootRestfulwebservices.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.SpringbootRestfulwebservices.dto.UserDto;
import com.example.SpringbootRestfulwebservices.entity.User;
import com.example.SpringbootRestfulwebservices.mapper.AutoUserMapper;
import com.example.SpringbootRestfulwebservices.mapper.UserMapper;
import com.example.SpringbootRestfulwebservices.repository.UserRepository;
import com.example.SpringbootRestfulwebservices.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		//convert dto into JPA entity
//		User user = new User(
//				userDto.getId(),
//				userDto.getFirstName(),
//				userDto.getLastName(),
//				userDto.getEmail()
//				);
//		User user = UserMapper.mapToUser(userDto);
//		User user = modelMapper.map(userDto, User.class);
		User user = AutoUserMapper.MAPPER.mapToUser(userDto);


		
		User savedUser = userRepository.save(user) ;
		
		//converting JPA into dto
//		UserDto savedUserDto = new UserDto(
//				savedUser.getId(),
//				savedUser.getFirstName(),
//				savedUser.getLastName(),
//				savedUser.getEmail()
//				);
//		UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
//		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);


		return savedUserDto;
	}

	@Override
	public UserDto getUserById(Long userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		User user =  optionalUser.get();
//		return UserMapper.mapToUserDto(user);
//		return modelMapper.map(user, UserDto.class);
		return AutoUserMapper.MAPPER.mapToUserDto(user);


	}

	@Override
	public List<UserDto> getAllUsers() {
//		List<User> users = userRepository.findAll();
//		return users;
		List<User> users = userRepository.findAll();
//		return users.stream().map(UserMapper::mapToUserDto)
//				.collect(Collectors.toList());
//		return users.stream().map((user) -> modelMapper.map(user, UserDto.class))
//				.collect(Collectors.toList());
		return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user))
				.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepository.save(existingUser);
//		return UserMapper.mapToUserDto(updatedUser);
//		return modelMapper.map(updatedUser, UserDto.class);
		return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);


	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}

}
