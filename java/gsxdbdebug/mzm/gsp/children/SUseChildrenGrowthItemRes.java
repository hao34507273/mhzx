/*    */ package mzm.gsp.children;
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
/*    */ public class SUseChildrenGrowthItemRes
/*    */   extends __SUseChildrenGrowthItemRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609376;
/*    */   public float growvalue;
/*    */   public long childrenid;
/*    */   public int itemkey;
/*    */   public int useitemcount;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609376;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseChildrenGrowthItemRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public SUseChildrenGrowthItemRes(float _growvalue_, long _childrenid_, int _itemkey_, int _useitemcount_)
/*    */   {
/* 39 */     this.growvalue = _growvalue_;
/* 40 */     this.childrenid = _childrenid_;
/* 41 */     this.itemkey = _itemkey_;
/* 42 */     this.useitemcount = _useitemcount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.growvalue);
/* 51 */     _os_.marshal(this.childrenid);
/* 52 */     _os_.marshal(this.itemkey);
/* 53 */     _os_.marshal(this.useitemcount);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.growvalue = _os_.unmarshal_float();
/* 59 */     this.childrenid = _os_.unmarshal_long();
/* 60 */     this.itemkey = _os_.unmarshal_int();
/* 61 */     this.useitemcount = _os_.unmarshal_int();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SUseChildrenGrowthItemRes)) {
/* 71 */       SUseChildrenGrowthItemRes _o_ = (SUseChildrenGrowthItemRes)_o1_;
/* 72 */       if (this.growvalue != _o_.growvalue) return false;
/* 73 */       if (this.childrenid != _o_.childrenid) return false;
/* 74 */       if (this.itemkey != _o_.itemkey) return false;
/* 75 */       if (this.useitemcount != _o_.useitemcount) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += Float.floatToIntBits(this.growvalue);
/* 84 */     _h_ += (int)this.childrenid;
/* 85 */     _h_ += this.itemkey;
/* 86 */     _h_ += this.useitemcount;
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.growvalue).append(",");
/* 94 */     _sb_.append(this.childrenid).append(",");
/* 95 */     _sb_.append(this.itemkey).append(",");
/* 96 */     _sb_.append(this.useitemcount).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SUseChildrenGrowthItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */