package com.capg.otms.ms.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity //this makes the class as an entity class which is mapped to a database table
@Table(name="Screen_tbl") //this specifies the name of the database table to which the class has to be mapped
public class Screen {
		@Id
		@Column(name="screenid")
		private int screenId;
		
		@GeneratedValue(strategy=GenerationType.SEQUENCE) //theatre id is auto generated 
		@Column(name="theatreid")
		private int theatreId;
		
		@Column(name="screenname")
		private String screenName;
		
		
		@DateTimeFormat(pattern = "yyyy/MM/dd ")
		private LocalDate movieEndDate;
		
		@Column(name = "rows_details")
		private int rows;
		
		@Column(name = "columns_details")
		private int columns;

		
		public Screen() {
			super();
		}
       //constructor with parameters
		public Screen(int screenId, int theatreId, String screenName, 
				LocalDate movieEndDate, int rows, int columns) {
			super();
			this.screenId = screenId;
			this.screenName = screenName;
			this.theatreId=theatreId;
			this.movieEndDate = movieEndDate;
			this.rows = rows;
			this.columns = columns;
		}

		public int getTheatreId() {
			return theatreId;
		}

		public void setTheatreId(int theatreId) {
			this.theatreId = theatreId;
		}

		public int getScreenId() {
			return screenId;
		}

		public void setScreenId(int screenId) {
			this.screenId = screenId;
		}
		 
		public String getScreenName() {
			return screenName;
		}

		public void setScreenName(String screenName) {
			this.screenName = screenName;
		}



		public LocalDate getMovieEndDate() {
			return movieEndDate;
		}

		public void setMovieEndDate(LocalDate movieEndDate) {
			this.movieEndDate = movieEndDate;
		}

		public int getRows() {
			return rows;
		}

		public void setRows(int rows) {
			this.rows = rows;
		}

		public int getColumns() {
			return columns;
		}

		public void setColumns(int columns) {
			this.columns = columns;
		}
 
		//returns the objects of parent class
		@Override
		public String toString() {
			return "Screen [screenId=" + screenId + ", theatreId=" +theatreId+ ", screenName=" + screenName 
					+ ", movieEndDate=" + movieEndDate + "]';  rows=" + rows + ", columns=" + columns + "]";
		}
}