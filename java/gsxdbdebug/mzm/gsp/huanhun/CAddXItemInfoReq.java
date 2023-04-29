/*     */ package mzm.gsp.huanhun;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.huanhun.main.PAddXItemInfoReq;
/*     */ 
/*     */ public class CAddXItemInfoReq
/*     */   extends __CAddXItemInfoReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584454;
/*     */   public long roleidseekhelp;
/*     */   public int itemindex;
/*     */   public ArrayList<GiveoutItemBean> items;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     if (roleid < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleid, new PAddXItemInfoReq(roleid, this.roleidseekhelp, this.itemindex, this.items));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12584454;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAddXItemInfoReq()
/*     */   {
/*  39 */     this.items = new ArrayList();
/*     */   }
/*     */   
/*     */   public CAddXItemInfoReq(long _roleidseekhelp_, int _itemindex_, ArrayList<GiveoutItemBean> _items_) {
/*  43 */     this.roleidseekhelp = _roleidseekhelp_;
/*  44 */     this.itemindex = _itemindex_;
/*  45 */     this.items = _items_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (GiveoutItemBean _v_ : this.items)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.roleidseekhelp);
/*  56 */     _os_.marshal(this.itemindex);
/*  57 */     _os_.compact_uint32(this.items.size());
/*  58 */     for (GiveoutItemBean _v_ : this.items) {
/*  59 */       _os_.marshal(_v_);
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.roleidseekhelp = _os_.unmarshal_long();
/*  66 */     this.itemindex = _os_.unmarshal_int();
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  68 */       GiveoutItemBean _v_ = new GiveoutItemBean();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.items.add(_v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof CAddXItemInfoReq)) {
/*  81 */       CAddXItemInfoReq _o_ = (CAddXItemInfoReq)_o1_;
/*  82 */       if (this.roleidseekhelp != _o_.roleidseekhelp) return false;
/*  83 */       if (this.itemindex != _o_.itemindex) return false;
/*  84 */       if (!this.items.equals(_o_.items)) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += (int)this.roleidseekhelp;
/*  93 */     _h_ += this.itemindex;
/*  94 */     _h_ += this.items.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.roleidseekhelp).append(",");
/* 102 */     _sb_.append(this.itemindex).append(",");
/* 103 */     _sb_.append(this.items).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\CAddXItemInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */