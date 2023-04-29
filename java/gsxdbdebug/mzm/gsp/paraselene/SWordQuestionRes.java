/*    */ package mzm.gsp.paraselene;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SWordQuestionRes
/*    */   extends __SWordQuestionRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598290;
/*    */   public int issuccess;
/*    */   public int seconds;
/*    */   public ArrayList<WordQuestionInfo> wordquestionres;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12598290;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SWordQuestionRes()
/*    */   {
/* 33 */     this.wordquestionres = new ArrayList();
/*    */   }
/*    */   
/*    */   public SWordQuestionRes(int _issuccess_, int _seconds_, ArrayList<WordQuestionInfo> _wordquestionres_) {
/* 37 */     this.issuccess = _issuccess_;
/* 38 */     this.seconds = _seconds_;
/* 39 */     this.wordquestionres = _wordquestionres_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (WordQuestionInfo _v_ : this.wordquestionres)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.issuccess);
/* 50 */     _os_.marshal(this.seconds);
/* 51 */     _os_.compact_uint32(this.wordquestionres.size());
/* 52 */     for (WordQuestionInfo _v_ : this.wordquestionres) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.issuccess = _os_.unmarshal_int();
/* 60 */     this.seconds = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 62 */       WordQuestionInfo _v_ = new WordQuestionInfo();
/* 63 */       _v_.unmarshal(_os_);
/* 64 */       this.wordquestionres.add(_v_);
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SWordQuestionRes)) {
/* 75 */       SWordQuestionRes _o_ = (SWordQuestionRes)_o1_;
/* 76 */       if (this.issuccess != _o_.issuccess) return false;
/* 77 */       if (this.seconds != _o_.seconds) return false;
/* 78 */       if (!this.wordquestionres.equals(_o_.wordquestionres)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.issuccess;
/* 87 */     _h_ += this.seconds;
/* 88 */     _h_ += this.wordquestionres.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.issuccess).append(",");
/* 96 */     _sb_.append(this.seconds).append(",");
/* 97 */     _sb_.append(this.wordquestionres).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\SWordQuestionRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */