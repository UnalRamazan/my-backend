package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.Entity.FollowerFollowing;
import org.example.Repository.FollowerFollowingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowerFollowingService {

    private final FollowerFollowingRepository followerFollowingRepository;

    public List<FollowerFollowing> getAllFollowerFollowing(){

        return followerFollowingRepository.findAll();
    }

    public void addFollowerFollowing(FollowerFollowing followerFollowing){

        followerFollowingRepository.save(followerFollowing);
    }

    public void deleteFollowerFollowing(long id){

        followerFollowingRepository.deleteById(id);
    }

    public FollowerFollowing updateFollowerFollowing(FollowerFollowing followerFollowing){
        if (followerFollowing == null && !followerFollowingRepository.existsById(followerFollowing.getId())) {
            return null;
        }

        return followerFollowingRepository.save(followerFollowing);
    }

    public FollowerFollowing getFollowerFollowingById(Long id){

        return followerFollowingRepository.findById(id).orElse(null);
    }
}
