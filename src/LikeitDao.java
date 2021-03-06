import java.util.ArrayList;

public class LikeitDao {
	public ArrayList<Likeit> likeits;

	private int no = 0;

	public LikeitDao() {
		likeits = new ArrayList<Likeit>();
		// 이것이 없으면 likeits는 일반변수임
	}

	// 좋아요 수
	public void insertLikeit(Likeit l) {
		l.setLikeId(no);
		no++;

		l.setLDate(Util.getCurrenDate());

		likeits.add(l);
	}

	public Likeit getLikeByArticleIdAndMemberId(int aid, int mid) {
		for (int i = 0; i < likeits.size(); i++) {
			Likeit like = likeits.get(i);
			if (like.getParentId() == aid && like.getMemberId() == mid) {
				return like;
			}
		}
		return null;
	}
	
	//좋아요 해제 - 삭제
	public void removeLikeit(Likeit rst) {
		likeits.remove(rst);
	}
	
	//좋아요 수
	public int getLikeCount(int id) {
		int cnt = 0;
		for (int i = 0; i < likeits.size(); i++) {
			Likeit like = likeits.get(i);
			if (like.getParentId() == id) {
				cnt++;
			}
		}
		return cnt;
	}
}
