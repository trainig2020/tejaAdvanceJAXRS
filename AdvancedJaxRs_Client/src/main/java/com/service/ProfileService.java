package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.database.DatabaseClass;
import com.model.Profile;


public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("ezhil", new Profile(1L, "ezhil", "Ezhilarasi", "E"));
		
	}
	
public List<Profile> getAllProfile(){
		
		return new ArrayList<Profile>(profiles.values());	
		
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	

}