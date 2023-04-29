/*    */ package mzm.gsp.gang;
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
/*    */ 
/*    */ 
/*    */ public class SCombineGangApplyRes
/*    */   extends __SCombineGangApplyRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589970;
/*    */   public long targetid;
/*    */   public String target_name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589970;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SCombineGangApplyRes()
/*    */   {
/* 34 */     this.target_name = "";
/*    */   }
/*    */   
/*    */   public SCombineGangApplyRes(long _targetid_, String _target_name_) {
/* 38 */     this.targetid = _targetid_;
/* 39 */     this.target_name = _target_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.targetid);
/* 48 */     _os_.marshal(this.target_name, "UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.targetid = _os_.unmarshal_long();
/* 54 */     this.target_name = _os_.unmarshal_String("UTF-16LE");
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SCombineGangApplyRes)) {
/* 64 */       SCombineGangApplyRes _o_ = (SCombineGangApplyRes)_o1_;
/* 65 */       if (this.targetid != _o_.targetid) return false;
/* 66 */       if (!this.target_name.equals(_o_.target_name)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.targetid;
/* 75 */     _h_ += this.target_name.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.targetid).append(",");
/* 83 */     _sb_.append("T").append(this.target_name.length()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SCombineGangApplyRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */