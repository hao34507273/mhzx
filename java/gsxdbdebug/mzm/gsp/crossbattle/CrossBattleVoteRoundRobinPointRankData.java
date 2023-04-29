/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class CrossBattleVoteRoundRobinPointRankData
/*    */   implements Marshal
/*    */ {
/*    */   public int rank;
/*    */   public CorpsBriefInfo corps_brief_info;
/*    */   public int point;
/*    */   public int win_num;
/*    */   public int lose_num;
/*    */   public int vote_num;
/*    */   public int vote_timestamp;
/*    */   
/*    */   public CrossBattleVoteRoundRobinPointRankData()
/*    */   {
/* 20 */     this.corps_brief_info = new CorpsBriefInfo();
/*    */   }
/*    */   
/*    */   public CrossBattleVoteRoundRobinPointRankData(int _rank_, CorpsBriefInfo _corps_brief_info_, int _point_, int _win_num_, int _lose_num_, int _vote_num_, int _vote_timestamp_) {
/* 24 */     this.rank = _rank_;
/* 25 */     this.corps_brief_info = _corps_brief_info_;
/* 26 */     this.point = _point_;
/* 27 */     this.win_num = _win_num_;
/* 28 */     this.lose_num = _lose_num_;
/* 29 */     this.vote_num = _vote_num_;
/* 30 */     this.vote_timestamp = _vote_timestamp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 34 */     if (!this.corps_brief_info._validator_()) return false;
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 39 */     _os_.marshal(this.rank);
/* 40 */     _os_.marshal(this.corps_brief_info);
/* 41 */     _os_.marshal(this.point);
/* 42 */     _os_.marshal(this.win_num);
/* 43 */     _os_.marshal(this.lose_num);
/* 44 */     _os_.marshal(this.vote_num);
/* 45 */     _os_.marshal(this.vote_timestamp);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.rank = _os_.unmarshal_int();
/* 51 */     this.corps_brief_info.unmarshal(_os_);
/* 52 */     this.point = _os_.unmarshal_int();
/* 53 */     this.win_num = _os_.unmarshal_int();
/* 54 */     this.lose_num = _os_.unmarshal_int();
/* 55 */     this.vote_num = _os_.unmarshal_int();
/* 56 */     this.vote_timestamp = _os_.unmarshal_int();
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CrossBattleVoteRoundRobinPointRankData)) {
/* 63 */       CrossBattleVoteRoundRobinPointRankData _o_ = (CrossBattleVoteRoundRobinPointRankData)_o1_;
/* 64 */       if (this.rank != _o_.rank) return false;
/* 65 */       if (!this.corps_brief_info.equals(_o_.corps_brief_info)) return false;
/* 66 */       if (this.point != _o_.point) return false;
/* 67 */       if (this.win_num != _o_.win_num) return false;
/* 68 */       if (this.lose_num != _o_.lose_num) return false;
/* 69 */       if (this.vote_num != _o_.vote_num) return false;
/* 70 */       if (this.vote_timestamp != _o_.vote_timestamp) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.rank;
/* 79 */     _h_ += this.corps_brief_info.hashCode();
/* 80 */     _h_ += this.point;
/* 81 */     _h_ += this.win_num;
/* 82 */     _h_ += this.lose_num;
/* 83 */     _h_ += this.vote_num;
/* 84 */     _h_ += this.vote_timestamp;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.rank).append(",");
/* 92 */     _sb_.append(this.corps_brief_info).append(",");
/* 93 */     _sb_.append(this.point).append(",");
/* 94 */     _sb_.append(this.win_num).append(",");
/* 95 */     _sb_.append(this.lose_num).append(",");
/* 96 */     _sb_.append(this.vote_num).append(",");
/* 97 */     _sb_.append(this.vote_timestamp).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CrossBattleVoteRoundRobinPointRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */