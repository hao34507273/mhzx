/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class AnswerInfo implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public String rolename;
/*    */   public int occupationid;
/*    */   public int gender;
/*    */   
/*    */   public AnswerInfo()
/*    */   {
/* 15 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public AnswerInfo(long _roleid_, String _rolename_, int _occupationid_, int _gender_) {
/* 19 */     this.roleid = _roleid_;
/* 20 */     this.rolename = _rolename_;
/* 21 */     this.occupationid = _occupationid_;
/* 22 */     this.gender = _gender_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.roleid);
/* 31 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 32 */     _os_.marshal(this.occupationid);
/* 33 */     _os_.marshal(this.gender);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.roleid = _os_.unmarshal_long();
/* 39 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 40 */     this.occupationid = _os_.unmarshal_int();
/* 41 */     this.gender = _os_.unmarshal_int();
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof AnswerInfo)) {
/* 48 */       AnswerInfo _o_ = (AnswerInfo)_o1_;
/* 49 */       if (this.roleid != _o_.roleid) return false;
/* 50 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 51 */       if (this.occupationid != _o_.occupationid) return false;
/* 52 */       if (this.gender != _o_.gender) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += (int)this.roleid;
/* 61 */     _h_ += this.rolename.hashCode();
/* 62 */     _h_ += this.occupationid;
/* 63 */     _h_ += this.gender;
/* 64 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuilder _sb_ = new StringBuilder();
/* 69 */     _sb_.append("(");
/* 70 */     _sb_.append(this.roleid).append(",");
/* 71 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 72 */     _sb_.append(this.occupationid).append(",");
/* 73 */     _sb_.append(this.gender).append(",");
/* 74 */     _sb_.append(")");
/* 75 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\AnswerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */