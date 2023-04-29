/*    */ package mzm.gsp.huanhun;
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
/*    */ public class SAddXItemInfoRep
/*    */   extends __SAddXItemInfoRep__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584456;
/*    */   public long roleidseekhelp;
/*    */   public int itemindex;
/*    */   public ItemInfo iteminfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584456;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAddXItemInfoRep()
/*    */   {
/* 35 */     this.iteminfo = new ItemInfo();
/*    */   }
/*    */   
/*    */   public SAddXItemInfoRep(long _roleidseekhelp_, int _itemindex_, ItemInfo _iteminfo_) {
/* 39 */     this.roleidseekhelp = _roleidseekhelp_;
/* 40 */     this.itemindex = _itemindex_;
/* 41 */     this.iteminfo = _iteminfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.iteminfo._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.roleidseekhelp);
/* 51 */     _os_.marshal(this.itemindex);
/* 52 */     _os_.marshal(this.iteminfo);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.roleidseekhelp = _os_.unmarshal_long();
/* 58 */     this.itemindex = _os_.unmarshal_int();
/* 59 */     this.iteminfo.unmarshal(_os_);
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SAddXItemInfoRep)) {
/* 69 */       SAddXItemInfoRep _o_ = (SAddXItemInfoRep)_o1_;
/* 70 */       if (this.roleidseekhelp != _o_.roleidseekhelp) return false;
/* 71 */       if (this.itemindex != _o_.itemindex) return false;
/* 72 */       if (!this.iteminfo.equals(_o_.iteminfo)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += (int)this.roleidseekhelp;
/* 81 */     _h_ += this.itemindex;
/* 82 */     _h_ += this.iteminfo.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.roleidseekhelp).append(",");
/* 90 */     _sb_.append(this.itemindex).append(",");
/* 91 */     _sb_.append(this.iteminfo).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\SAddXItemInfoRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */