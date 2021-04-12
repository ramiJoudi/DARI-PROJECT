package VORTEX.DARIPROJECT.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{

}
