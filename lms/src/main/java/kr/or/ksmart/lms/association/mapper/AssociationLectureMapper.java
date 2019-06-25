package kr.or.ksmart.lms.association.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.lms.association.vo.Institution;
import kr.or.ksmart.lms.association.vo.InfoLecture;
import kr.or.ksmart.lms.association.vo.InfoSubject;

@Mapper
public interface AssociationLectureMapper {
	
	// infoLectureSort 리스트 출력하는 메서드
	public List<InfoLecture> associationSelectInfoLectureSortList();
	// infoLectureName 리스트 출력하는 메서드
	public List<InfoLecture > associationSelectInfoLectureNameList(String lectureSort);
	// infoSubject 리스트 출력하는 메서드
	public List<InfoSubject> associationSelectSubjectListByLectureCode(String lectureCode);
	
	// institution 리스트 출력하는 메서드
	public List<Institution> associationSelectInstitutionList();
	// institution 키워드로 검색하는 메서드
	public List<Institution> associationSelectInstitutionListByKeyword(String institutionName);
}