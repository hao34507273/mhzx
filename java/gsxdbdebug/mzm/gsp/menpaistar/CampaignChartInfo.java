/*    */ package mzm.gsp.menpaistar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class CampaignChartInfo implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public Octets role_name;
/*    */   public int occupationid;
/*    */   public int rank;
/*    */   public int point;
/*    */   public VoteAwardInfo vote_award_info;
/*    */   
/*    */   public CampaignChartInfo()
/*    */   {
/* 19 */     this.role_name = new Octets();
/* 20 */     this.vote_award_info = new VoteAwardInfo();
/*    */   }
/*    */   
/*    */   public CampaignChartInfo(long _roleid_, Octets _role_name_, int _occupationid_, int _rank_, int _point_, VoteAwardInfo _vote_award_info_) {
/* 24 */     this.roleid = _roleid_;
/* 25 */     this.role_name = _role_name_;
/* 26 */     this.occupationid = _occupationid_;
/* 27 */     this.rank = _rank_;
/* 28 */     this.point = _point_;
/* 29 */     this.vote_award_info = _vote_award_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 33 */     if (!this.vote_award_info._validator_()) return false;
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     _os_.marshal(this.roleid);
/* 39 */     _os_.marshal(this.role_name);
/* 40 */     _os_.marshal(this.occupationid);
/* 41 */     _os_.marshal(this.rank);
/* 42 */     _os_.marshal(this.point);
/* 43 */     _os_.marshal(this.vote_award_info);
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     this.roleid = _os_.unmarshal_long();
/* 49 */     this.role_name = _os_.unmarshal_Octets();
/* 50 */     this.occupationid = _os_.unmarshal_int();
/* 51 */     this.rank = _os_.unmarshal_int();
/* 52 */     this.point = _os_.unmarshal_int();
/* 53 */     this.vote_award_info.unmarshal(_os_);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof CampaignChartInfo)) {
/* 60 */       CampaignChartInfo _o_ = (CampaignChartInfo)_o1_;
/* 61 */       if (this.roleid != _o_.roleid) return false;
/* 62 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 63 */       if (this.occupationid != _o_.occupationid) return false;
/* 64 */       if (this.rank != _o_.rank) return false;
/* 65 */       if (this.point != _o_.point) return false;
/* 66 */       if (!this.vote_award_info.equals(_o_.vote_award_info)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.roleid;
/* 75 */     _h_ += this.role_name.hashCode();
/* 76 */     _h_ += this.occupationid;
/* 77 */     _h_ += this.rank;
/* 78 */     _h_ += this.point;
/* 79 */     _h_ += this.vote_award_info.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.roleid).append(",");
/* 87 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 88 */     _sb_.append(this.occupationid).append(",");
/* 89 */     _sb_.append(this.rank).append(",");
/* 90 */     _sb_.append(this.point).append(",");
/* 91 */     _sb_.append(this.vote_award_info).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\CampaignChartInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */