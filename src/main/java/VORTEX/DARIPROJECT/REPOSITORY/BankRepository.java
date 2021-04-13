package VORTEX.DARIPROJECT.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.Bank;
@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{
	@Query(value = "SELECT * FROM Bank b WHERE b.bankname = :bankname", nativeQuery = true)
	Bank findByBankname(@Param("bankname")String bankname);
	@Query(value = "SELECT * FROM Bank b WHERE b.bankname = :bankname", nativeQuery = true)
	List<Bank> findByBanknameL(@Param("bankname")String bankname);
	@Query(value = "SELECT interest_rate FROM Bank b WHERE b.bankname = :bankname", nativeQuery = true)
	float findByBanknameIr(@Param("bankname")String bankname); //find interest rate by name
}
