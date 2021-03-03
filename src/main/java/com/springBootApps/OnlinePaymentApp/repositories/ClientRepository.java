package com.springBootApps.OnlinePaymentApp.repositories;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springBootApps.OnlinePaymentApp.domain.Client;

public interface ClientRepository extends JpaRepository <Client, Integer>{
	
	Set<Client> findByEmail(String email);
}
