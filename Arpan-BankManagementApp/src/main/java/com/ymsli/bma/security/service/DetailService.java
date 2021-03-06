package com.ymsli.bma.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ymsli.bma.entity.Employee;
import com.ymsli.bma.service.EmployeeService;

@Service
public class DetailService implements UserDetailsService {

	
	@Autowired
	private EmployeeService empService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee emp = empService.getEmployeeByUsername(username); 

		if (emp == null) {
			throw new UsernameNotFoundException(username + ": Such username not found");
		}
		/*User springUser = new User(	emp.getEmpUsername(), 
										emp.getEmpPassword(), 
										AuthorityUtils.createAuthorityList(new String[] {
										emp.getEmpRole()})
								);
		return springUser;*/
		return new SecurityUser(emp);
	}

}



