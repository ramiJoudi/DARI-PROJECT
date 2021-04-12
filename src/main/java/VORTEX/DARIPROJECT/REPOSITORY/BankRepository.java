package VORTEX.DARIPROJECT.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.Bank;
@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{

}
