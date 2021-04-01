package VORTEX.DARIPROJECT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.WishList;
@Repository
public interface WishListrepo extends JpaRepository<WishList,Integer>{

}
