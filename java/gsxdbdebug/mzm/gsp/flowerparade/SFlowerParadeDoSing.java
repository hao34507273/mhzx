/*    */ package mzm.gsp.flowerparade;
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
/*    */ public class SFlowerParadeDoSing
/*    */   extends __SFlowerParadeDoSing__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625673;
/*    */   public int actionindex;
/*    */   public int activityid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12625673;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SFlowerParadeDoSing() {}
/*    */   
/*    */ 
/*    */   public SFlowerParadeDoSing(int _actionindex_, int _activityid_)
/*    */   {
/* 37 */     this.actionindex = _actionindex_;
/* 38 */     this.activityid = _activityid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.actionindex);
/* 47 */     _os_.marshal(this.activityid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.actionindex = _os_.unmarshal_int();
/* 53 */     this.activityid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SFlowerParadeDoSing)) {
/* 63 */       SFlowerParadeDoSing _o_ = (SFlowerParadeDoSing)_o1_;
/* 64 */       if (this.actionindex != _o_.actionindex) return false;
/* 65 */       if (this.activityid != _o_.activityid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.actionindex;
/* 74 */     _h_ += this.activityid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.actionindex).append(",");
/* 82 */     _sb_.append(this.activityid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SFlowerParadeDoSing _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.actionindex - _o_.actionindex;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.activityid - _o_.activityid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\SFlowerParadeDoSing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */