/*    */ package mzm.gsp.menpaistar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGangCanvassFailed
/*    */   extends __SGangCanvassFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12612373;
/*    */   public static final int ERROR_NOT_CAMPAIGN = -1;
/*    */   public static final int ERROR_CD = -2;
/*    */   public static final int ERROR_ACTIVITY_IN_AWARD = -3;
/*    */   public static final int ERROR_SWITH_OCCUPATION = -4;
/*    */   public long target_roleid;
/*    */   public Octets text;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12612373;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGangCanvassFailed()
/*    */   {
/* 40 */     this.text = new Octets();
/*    */   }
/*    */   
/*    */   public SGangCanvassFailed(long _target_roleid_, Octets _text_, int _retcode_) {
/* 44 */     this.target_roleid = _target_roleid_;
/* 45 */     this.text = _text_;
/* 46 */     this.retcode = _retcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.target_roleid);
/* 55 */     _os_.marshal(this.text);
/* 56 */     _os_.marshal(this.retcode);
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.target_roleid = _os_.unmarshal_long();
/* 62 */     this.text = _os_.unmarshal_Octets();
/* 63 */     this.retcode = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SGangCanvassFailed)) {
/* 73 */       SGangCanvassFailed _o_ = (SGangCanvassFailed)_o1_;
/* 74 */       if (this.target_roleid != _o_.target_roleid) return false;
/* 75 */       if (!this.text.equals(_o_.text)) return false;
/* 76 */       if (this.retcode != _o_.retcode) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += (int)this.target_roleid;
/* 85 */     _h_ += this.text.hashCode();
/* 86 */     _h_ += this.retcode;
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.target_roleid).append(",");
/* 94 */     _sb_.append("B").append(this.text.size()).append(",");
/* 95 */     _sb_.append(this.retcode).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\SGangCanvassFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */