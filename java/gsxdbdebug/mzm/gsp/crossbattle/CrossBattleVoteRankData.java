/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class CrossBattleVoteRankData
/*    */   implements Marshal
/*    */ {
/*    */   public int rank;
/*    */   public CorpsBriefInfo corps_brief_info;
/*    */   public int vote_num;
/*    */   public int vote_timestamp;
/*    */   public float average_fight_value;
/*    */   
/*    */   public CrossBattleVoteRankData()
/*    */   {
/* 18 */     this.corps_brief_info = new CorpsBriefInfo();
/*    */   }
/*    */   
/*    */   public CrossBattleVoteRankData(int _rank_, CorpsBriefInfo _corps_brief_info_, int _vote_num_, int _vote_timestamp_, float _average_fight_value_) {
/* 22 */     this.rank = _rank_;
/* 23 */     this.corps_brief_info = _corps_brief_info_;
/* 24 */     this.vote_num = _vote_num_;
/* 25 */     this.vote_timestamp = _vote_timestamp_;
/* 26 */     this.average_fight_value = _average_fight_value_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     if (!this.corps_brief_info._validator_()) return false;
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.rank);
/* 36 */     _os_.marshal(this.corps_brief_info);
/* 37 */     _os_.marshal(this.vote_num);
/* 38 */     _os_.marshal(this.vote_timestamp);
/* 39 */     _os_.marshal(this.average_fight_value);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 44 */     this.rank = _os_.unmarshal_int();
/* 45 */     this.corps_brief_info.unmarshal(_os_);
/* 46 */     this.vote_num = _os_.unmarshal_int();
/* 47 */     this.vote_timestamp = _os_.unmarshal_int();
/* 48 */     this.average_fight_value = _os_.unmarshal_float();
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof CrossBattleVoteRankData)) {
/* 55 */       CrossBattleVoteRankData _o_ = (CrossBattleVoteRankData)_o1_;
/* 56 */       if (this.rank != _o_.rank) return false;
/* 57 */       if (!this.corps_brief_info.equals(_o_.corps_brief_info)) return false;
/* 58 */       if (this.vote_num != _o_.vote_num) return false;
/* 59 */       if (this.vote_timestamp != _o_.vote_timestamp) return false;
/* 60 */       if (this.average_fight_value != _o_.average_fight_value) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.rank;
/* 69 */     _h_ += this.corps_brief_info.hashCode();
/* 70 */     _h_ += this.vote_num;
/* 71 */     _h_ += this.vote_timestamp;
/* 72 */     _h_ += Float.floatToIntBits(this.average_fight_value);
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.rank).append(",");
/* 80 */     _sb_.append(this.corps_brief_info).append(",");
/* 81 */     _sb_.append(this.vote_num).append(",");
/* 82 */     _sb_.append(this.vote_timestamp).append(",");
/* 83 */     _sb_.append(this.average_fight_value).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CrossBattleVoteRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */