/*    */ package mzm.gsp.pet;
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
/*    */ public class SUseGrowItemRes
/*    */   extends __SUseGrowItemRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590596;
/*    */   public float addgrow;
/*    */   public long petid;
/*    */   public int growitemleft;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590596;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUseGrowItemRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public SUseGrowItemRes(float _addgrow_, long _petid_, int _growitemleft_)
/*    */   {
/* 38 */     this.addgrow = _addgrow_;
/* 39 */     this.petid = _petid_;
/* 40 */     this.growitemleft = _growitemleft_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.addgrow);
/* 49 */     _os_.marshal(this.petid);
/* 50 */     _os_.marshal(this.growitemleft);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.addgrow = _os_.unmarshal_float();
/* 56 */     this.petid = _os_.unmarshal_long();
/* 57 */     this.growitemleft = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SUseGrowItemRes)) {
/* 67 */       SUseGrowItemRes _o_ = (SUseGrowItemRes)_o1_;
/* 68 */       if (this.addgrow != _o_.addgrow) return false;
/* 69 */       if (this.petid != _o_.petid) return false;
/* 70 */       if (this.growitemleft != _o_.growitemleft) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += Float.floatToIntBits(this.addgrow);
/* 79 */     _h_ += (int)this.petid;
/* 80 */     _h_ += this.growitemleft;
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.addgrow).append(",");
/* 88 */     _sb_.append(this.petid).append(",");
/* 89 */     _sb_.append(this.growitemleft).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SUseGrowItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */