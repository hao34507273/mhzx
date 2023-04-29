/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncQYXTGangAnswer
/*    */   extends __SSyncQYXTGangAnswer__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594752;
/*    */   public int questionid;
/*    */   public long seekhelproleid;
/*    */   public String helpanswerstring;
/*    */   public long helpanswerroleid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594752;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncQYXTGangAnswer()
/*    */   {
/* 36 */     this.helpanswerstring = "";
/*    */   }
/*    */   
/*    */   public SSyncQYXTGangAnswer(int _questionid_, long _seekhelproleid_, String _helpanswerstring_, long _helpanswerroleid_) {
/* 40 */     this.questionid = _questionid_;
/* 41 */     this.seekhelproleid = _seekhelproleid_;
/* 42 */     this.helpanswerstring = _helpanswerstring_;
/* 43 */     this.helpanswerroleid = _helpanswerroleid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.questionid);
/* 52 */     _os_.marshal(this.seekhelproleid);
/* 53 */     _os_.marshal(this.helpanswerstring, "UTF-16LE");
/* 54 */     _os_.marshal(this.helpanswerroleid);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.questionid = _os_.unmarshal_int();
/* 60 */     this.seekhelproleid = _os_.unmarshal_long();
/* 61 */     this.helpanswerstring = _os_.unmarshal_String("UTF-16LE");
/* 62 */     this.helpanswerroleid = _os_.unmarshal_long();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SSyncQYXTGangAnswer)) {
/* 72 */       SSyncQYXTGangAnswer _o_ = (SSyncQYXTGangAnswer)_o1_;
/* 73 */       if (this.questionid != _o_.questionid) return false;
/* 74 */       if (this.seekhelproleid != _o_.seekhelproleid) return false;
/* 75 */       if (!this.helpanswerstring.equals(_o_.helpanswerstring)) return false;
/* 76 */       if (this.helpanswerroleid != _o_.helpanswerroleid) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.questionid;
/* 85 */     _h_ += (int)this.seekhelproleid;
/* 86 */     _h_ += this.helpanswerstring.hashCode();
/* 87 */     _h_ += (int)this.helpanswerroleid;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.questionid).append(",");
/* 95 */     _sb_.append(this.seekhelproleid).append(",");
/* 96 */     _sb_.append("T").append(this.helpanswerstring.length()).append(",");
/* 97 */     _sb_.append(this.helpanswerroleid).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SSyncQYXTGangAnswer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */