package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.BookFlight;

import java.util.List;

@Repository
public interface BookFlightRepository extends JpaRepository<BookFlight, Long>{

    @Query("Select f from Passenger f where f.bookId = :#{bookId} and f.age = 'adult'")
    public List<Passenger> getAdultByBookId(@Param("bookId") long bookId);

    @Query("Select f from Passenger f where f.bookId = :#{bookId} and f.age = 'child'")
    public List<Passenger> getChildByBookId(@Param("bookId") long bookId);

    @Query("Select f from Passenger f where f.bookId = :#{bookId} and f.luggage > 0")
    public List<Passenger> getPassengersLuggageByBookId(@Param("bookId") long bookId);

}
