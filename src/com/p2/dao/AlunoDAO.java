package com.p2.dao;

import java.util.List;

import com.p2.beans.Aluno;

public interface AlunoDAO {
	public void addAluno( Aluno aluno );
	public void deleteAluno( int alunoId );
	public void updateAluno( Aluno aluno );
	public List<Aluno> getAllAlunos();
	public Aluno getAlunoById( int alunoId );
}