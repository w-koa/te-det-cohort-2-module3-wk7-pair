package com.techelevator.ssg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.forum.ForumPost;
import com.techelevator.ssg.model.forum.JdbcForumDao;

@Controller
public class SpaceForumController {

	@Autowired
	private JdbcForumDao forumDao;
	
	@RequestMapping(path="/spaceForum", method=RequestMethod.GET)
	public String displaySpaceForum(ModelMap map) {
		List<ForumPost> forumPosts = forumDao.getAllPosts();
		map.put("forumPosts", forumPosts);
		return "spaceForum";
	}
	
	@RequestMapping(path="/postAMessage", method = RequestMethod.GET)
	public String displayPostAMessage() {
		return "postAMessage";
	}
	
	@RequestMapping(path="/postAMessage", method = RequestMethod.POST)
	public String displayPostAMessageInput(ForumPost post) {
		forumDao.save(post);
		return "redirect:/spaceForum";
	}
	
	@RequestMapping(path="/spaceForumResult", method=RequestMethod.GET)
	public String displaySpaceAfterPost(ModelMap map) {
		List<ForumPost> forumPosts = forumDao.getAllPosts();
		map.put("forumPosts", forumPosts);
		return "spaceForum";
	}
	
}