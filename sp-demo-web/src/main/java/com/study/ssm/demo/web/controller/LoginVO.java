package com.study.ssm.demo.web.controller;

import java.io.Serializable;

class LoginVO implements Serializable{
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String name;
    	private String password;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "LoginVO [name=" + name + ", password=" + password + "]";
		}
		public LoginVO(String name, String password) {
			super();
			this.name = name;
			this.password = password;
		}
		public LoginVO() {
		}
    	
    }