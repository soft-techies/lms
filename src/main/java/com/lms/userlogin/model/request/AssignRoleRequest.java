package com.lms.userlogin.model.request;

public class AssignRoleRequest {
	
	   private Long userId;
	    private String roleName;
	    private String email;
	    
	    
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getRoleName() {
			return roleName;
		}
		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}

}
