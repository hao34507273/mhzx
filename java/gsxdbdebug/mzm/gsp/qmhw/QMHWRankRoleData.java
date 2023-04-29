/*    */ package mzm.gsp.qmhw;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class QMHWRankRoleData implements Marshal
/*    */ {
/*    */   public int rank;
/*    */   public long roleid;
/*    */   public int occupation;
/*    */   public String rolename;
/*    */   public int score;
/*    */   
/*    */   public QMHWRankRoleData()
/*    */   {
/* 16 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public QMHWRankRoleData(int _rank_, long _roleid_, int _occupation_, String _rolename_, int _score_) {
/* 20 */     this.rank = _rank_;
/* 21 */     this.roleid = _roleid_;
/* 22 */     this.occupation = _occupation_;
/* 23 */     this.rolename = _rolename_;
/* 24 */     this.score = _score_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.rank);
/* 33 */     _os_.marshal(this.roleid);
/* 34 */     _os_.marshal(this.occupation);
/* 35 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 36 */     _os_.marshal(this.score);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.rank = _os_.unmarshal_int();
/* 42 */     this.roleid = _os_.unmarshal_long();
/* 43 */     this.occupation = _os_.unmarshal_int();
/* 44 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 45 */     this.score = _os_.unmarshal_int();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof QMHWRankRoleData)) {
/* 52 */       QMHWRankRoleData _o_ = (QMHWRankRoleData)_o1_;
/* 53 */       if (this.rank != _o_.rank) return false;
/* 54 */       if (this.roleid != _o_.roleid) return false;
/* 55 */       if (this.occupation != _o_.occupation) return false;
/* 56 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 57 */       if (this.score != _o_.score) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.rank;
/* 66 */     _h_ += (int)this.roleid;
/* 67 */     _h_ += this.occupation;
/* 68 */     _h_ += this.rolename.hashCode();
/* 69 */     _h_ += this.score;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.rank).append(",");
/* 77 */     _sb_.append(this.roleid).append(",");
/* 78 */     _sb_.append(this.occupation).append(",");
/* 79 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 80 */     _sb_.append(this.score).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\QMHWRankRoleData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */