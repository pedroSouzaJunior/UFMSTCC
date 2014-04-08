package versao2;

/**
 * @author Urbieta Souza
 *
 */

import java.io.IOException;
import java.io.File;
import java.util.Set;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.internal.storage.file.*;
import javax.swing.JFileChooser;

/**
 * @author danielli
 *
 *
 *         classe Jgit
 */
public class JGit {

	//atributos
	String localPath;
	String remotePath;
	Repository localRepository;
	Git git;
	Repository myRepo;
	File myfile;
	File testFile;
	Set added;
	JFileChooser myArq;
	/**
	 * construtor da classe
	 */
	@SuppressWarnings("nls")
	public JGit() {
		localPath = "";
		remotePath = "";
		myArq = new JFileChooser();
	}

	/* ================ metodos geters e seters ===================== */

	/**
	 * @return the localPath
	 */
	public String getLocalPath() {
		return this.localPath;
	}

	/**
	 * @param localPath
	 *            the localPath to set
	 */
	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

	/**
	 * @return the remotePath
	 */
	public String getRemotePath() {
		return this.remotePath;
	}

	/**
	 * @param remotePath
	 *            the remotePath to set
	 */
	public void setRemotePath(String remotePath) {
		this.remotePath = remotePath;
	}

	/**
	 * @return the localRepository
	 */
	public Repository getLocalRepository() {
		return this.localRepository;
	}

	/**
	 * @param localRepository
	 *            the localRepository to set
	 */
	public void setLocalRepository(Repository localRepository) {
		this.localRepository = localRepository;
	}

	/**
	 * @return the git
	 */
	public Git getGit() {
		return this.git;
	}

	/**
	 * @param git
	 *            the git to set
	 */
	public void setGit(Git git) {
		this.git = git;
	}

	/**
	 * @return the myRepo
	 */
	public Repository getMyRepo() {
		return this.myRepo;
	}

	/**
	 * @param myRepo
	 *            the myRepo to set
	 */
	public void setMyRepo(Repository myRepo) {
		this.myRepo = myRepo;
	}

	/**
	 * @return the myfile
	 */
	public File getMyfile() {
		return this.myfile;
	}

	/**
	 * @param myfile
	 *            the myfile to set
	 */
	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

	/**
	 * @return File
	 */
	public File getTestFile() {
		return testFile;
	}

	/**
	 * @param testFile
	 */

	public void setTestFile(File testFile) {
		this.testFile = testFile;
	}

	/**
	 * @return Set
	 */
	public Set getAdded() {
		return this.added;
	}

	/**
	 * @param added
	 */
	public void setAdded(Set added) {
		this.added = added;
	}

	/* ==============METHODS========================= */

	/**
	 * @throws IOException
	 *             metodo init usado para inicialização de um novo repositorio
	 */
	@SuppressWarnings("nls")
	public void init() throws IOException {

		setLocalPath("/home/pedro/novoRepositorio");
		setMyRepo(new FileRepository(localPath + "/.git"));
		git = new Git(myRepo);
		System.out.print(myRepo);
		myRepo.getRepositoryState();
	}


	/**
	 * @throws IOException
	 * @metodo para criação de um novo repositorio
	 */
	@SuppressWarnings("nls")
	public void testCreate() throws IOException {

		setMyRepo(new FileRepository(localPath + "/.git"));
		myRepo.create();
	}

	/**
	 * @throws GitAPIException
	 * @throws NoFilepatternException
	 * @throws IOException
	 *             metodo para adicionar um novo arquivo ao repositorio arquivo
	 *             passa a ser monitorado pelo repositorio
	 */
	@SuppressWarnings("nls")
	public void testAdd() throws NoFilepatternException,
			GitAPIException, IOException {

		setTestFile(new File(localPath + "/testFile"));
		testFile.createNewFile();
		git.add().addFilepattern("testFile").call();
		setAdded(git.status().call().getAdded());
		System.out.print(added);
	}







}