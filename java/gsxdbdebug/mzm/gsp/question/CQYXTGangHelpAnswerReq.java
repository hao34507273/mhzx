/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.question.main.PCQYXTGangHelpAnswerReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CQYXTGangHelpAnswerReq
/*    */   extends __CQYXTGangHelpAnswerReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594750;
/*    */   public int questioncfgid;
/*    */   public long seekhelproleid;
/*    */   public String helpanswerstring;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCQYXTGangHelpAnswerReq(roleId, this.seekhelproleid, this.questioncfgid, this.helpanswerstring));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12594750;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CQYXTGangHelpAnswerReq()
/*    */   {
/* 40 */     this.helpanswerstring = "";
/*    */   }
/*    */   
/*    */   public CQYXTGangHelpAnswerReq(int _questioncfgid_, long _seekhelproleid_, String _helpanswerstring_) {
/* 44 */     this.questioncfgid = _questioncfgid_;
/* 45 */     this.seekhelproleid = _seekhelproleid_;
/* 46 */     this.helpanswerstring = _helpanswerstring_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.questioncfgid);
/* 55 */     _os_.marshal(this.seekhelproleid);
/* 56 */     _os_.marshal(this.helpanswerstring, "UTF-16LE");
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.questioncfgid = _os_.unmarshal_int();
/* 62 */     this.seekhelproleid = _os_.unmarshal_long();
/* 63 */     this.helpanswerstring = _os_.unmarshal_String("UTF-16LE");
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof CQYXTGangHelpAnswerReq)) {
/* 73 */       CQYXTGangHelpAnswerReq _o_ = (CQYXTGangHelpAnswerReq)_o1_;
/* 74 */       if (this.questioncfgid != _o_.questioncfgid) return false;
/* 75 */       if (this.seekhelproleid != _o_.seekhelproleid) return false;
/* 76 */       if (!this.helpanswerstring.equals(_o_.helpanswerstring)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.questioncfgid;
/* 85 */     _h_ += (int)this.seekhelproleid;
/* 86 */     _h_ += this.helpanswerstring.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.questioncfgid).append(",");
/* 94 */     _sb_.append(this.seekhelproleid).append(",");
/* 95 */     _sb_.append("T").append(this.helpanswerstring.length()).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\CQYXTGangHelpAnswerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */