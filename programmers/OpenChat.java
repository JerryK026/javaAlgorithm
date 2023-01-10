package boj;

import java.util.*;

public class OpenChat {
    static final String ENTER = "Enter";
    static final String LEAVE = "Leave";
    static final String CHANGE = "Change";

    class Member {
        private String uid;
        private String name;

        public Member(String uid, String name) {
            this.uid = uid;
            this.name = name;
        }

        public void changeName(String newName) {
            name = newName;
        }

        public String name() {
            return name;
        }
    }

    class MemberRecord {
        private String access;
        private Member member;

        public MemberRecord(String access, Member member) {
            this.access = access;
            this.member = member;
        }

        @Override
        public String toString() {
            return member.name() + "님이 " + accessMessage();
        }

        private String accessMessage() {
            if (this.access.equals(ENTER)) {
                return "들어왔습니다.";
            }
            if (this.access.equals(LEAVE)) {
                return "나갔습니다.";
            }
            throw new IllegalArgumentException("존재하지 않는 access type");
        }
    }

    public String[] solution(String[] record) {
        // key : uid
        Map<String, Member> db = new HashMap<>();
        List<MemberRecord> modifiedRecord = new ArrayList<>();

        for (String singleRecord : record) {
            String[] target = singleRecord.split(" ");
            String access = extractAccess(target);
            String uid = extractUid(target);

            if (access.equals(ENTER)) {
                String name = extractName(target);
                Member member = existMember(db, uid, name);
                member.changeName(name);
                modifiedRecord.add(new MemberRecord(access, member));
            } else if (access.equals(LEAVE)) {
                Member member = db.get(uid);
                modifiedRecord.add(new MemberRecord(access, member));
            } else if (access.equals(CHANGE)) {
                String name = extractName(target);
                Member member = db.get(uid);
                member.changeName(name);
            }
        }

        List<String> answer = new ArrayList<>();
        for (MemberRecord mr : modifiedRecord) {
            answer.add(mr.toString());
        }

        return answer.stream().toArray(String[]::new);
    }

    private String extractAccess(String[] target) {
        return target[0];
    }

    private String extractUid(String[] target) {
        return target[1];
    }

    private String extractName(String[] target) {
        return target[2];
    }

    private Member existMember(Map<String, Member> db, String uid, String name) {
        if (!db.containsKey(uid)) {
            Member member = new Member(uid, name);
            db.put(uid, member);
            return member;
        }
        return db.get(uid);
    }
}
