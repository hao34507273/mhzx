/*    */ package mzm.gsp.signaward;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SynAwardBeforeSignRes
/*    */   extends __SynAwardBeforeSignRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12593423;
/*    */   public ArrayList<Integer> awardeddays;
/*    */   public int day;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12593423;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SynAwardBeforeSignRes()
/*    */   {
/* 34 */     this.awardeddays = new ArrayList();
/*    */   }
/*    */   
/*    */   public SynAwardBeforeSignRes(ArrayList<Integer> _awardeddays_, int _day_) {
/* 38 */     this.awardeddays = _awardeddays_;
/* 39 */     this.day = _day_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.awardeddays.size());
/* 48 */     for (Integer _v_ : this.awardeddays) {
/* 49 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 51 */     _os_.marshal(this.day);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 58 */       int _v_ = _os_.unmarshal_int();
/* 59 */       this.awardeddays.add(Integer.valueOf(_v_));
/*    */     }
/* 61 */     this.day = _os_.unmarshal_int();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SynAwardBeforeSignRes)) {
/* 71 */       SynAwardBeforeSignRes _o_ = (SynAwardBeforeSignRes)_o1_;
/* 72 */       if (!this.awardeddays.equals(_o_.awardeddays)) return false;
/* 73 */       if (this.day != _o_.day) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.awardeddays.hashCode();
/* 82 */     _h_ += this.day;
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.awardeddays).append(",");
/* 90 */     _sb_.append(this.day).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\SynAwardBeforeSignRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */