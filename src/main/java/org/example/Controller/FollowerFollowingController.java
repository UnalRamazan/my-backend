package org.example.Controller;

import org.example.Entity.FollowerFollowing;
import org.example.Service.FollowerFollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follower-followings")
public class FollowerFollowingController {

    private final FollowerFollowingService followerFollowingService;

    @Autowired
    public FollowerFollowingController(FollowerFollowingService followerFollowingService) {
        this.followerFollowingService = followerFollowingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<FollowerFollowing>> getAllFollowerFollowing() {
        List<FollowerFollowing> followerFollowings = followerFollowingService.getAllFollowerFollowing();
        return new ResponseEntity<>(followerFollowings, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addFollowerFollowing(@RequestBody FollowerFollowing followerFollowing) {
        followerFollowingService.addFollowerFollowing(followerFollowing);
        return new ResponseEntity<>("FollowerFollowing added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFollowerFollowing(@PathVariable long id) {
        followerFollowingService.deleteFollowerFollowing(id);
        return new ResponseEntity<>("FollowerFollowing deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateFollowerFollowing(@RequestBody FollowerFollowing followerFollowing) {
        FollowerFollowing updatedFollowerFollowing = followerFollowingService.updateFollowerFollowing(followerFollowing);
        if (updatedFollowerFollowing != null) {
            return new ResponseEntity<>("FollowerFollowing updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update FollowerFollowing. FollowerFollowing not found.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FollowerFollowing> getFollowerFollowingById(@PathVariable Long id) {
        FollowerFollowing followerFollowing = followerFollowingService.getFollowerFollowingById(id);
        if (followerFollowing != null) {
            return new ResponseEntity<>(followerFollowing, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}