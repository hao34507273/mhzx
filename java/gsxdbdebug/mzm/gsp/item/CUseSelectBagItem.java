/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PUseSelectBagItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CUseSelectBagItem
/*     */   extends __CUseSelectBagItem__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584825;
/*     */   public long uuid;
/*     */   public int selectindex;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PUseSelectBagItem(roleId, this.uuid, this.selectindex));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12584825;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CUseSelectBagItem() {}
/*     */   
/*     */ 
/*     */   public CUseSelectBagItem(long _uuid_, int _selectindex_)
/*     */   {
/*  43 */     this.uuid = _uuid_;
/*  44 */     this.selectindex = _selectindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.uuid);
/*  53 */     _os_.marshal(this.selectindex);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.uuid = _os_.unmarshal_long();
/*  59 */     this.selectindex = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CUseSelectBagItem)) {
/*  69 */       CUseSelectBagItem _o_ = (CUseSelectBagItem)_o1_;
/*  70 */       if (this.uuid != _o_.uuid) return false;
/*  71 */       if (this.selectindex != _o_.selectindex) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.uuid;
/*  80 */     _h_ += this.selectindex;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.uuid).append(",");
/*  88 */     _sb_.append(this.selectindex).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CUseSelectBagItem _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.selectindex - _o_.selectindex;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CUseSelectBagItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */