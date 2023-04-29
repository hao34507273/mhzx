/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncRoleStatusChange
/*     */   extends __SSyncRoleStatusChange__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590899;
/*     */   public long roleid;
/*     */   public ArrayList<Integer> removelist;
/*     */   public ArrayList<Integer> addlist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590899;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncRoleStatusChange()
/*     */   {
/*  35 */     this.removelist = new ArrayList();
/*  36 */     this.addlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncRoleStatusChange(long _roleid_, ArrayList<Integer> _removelist_, ArrayList<Integer> _addlist_) {
/*  40 */     this.roleid = _roleid_;
/*  41 */     this.removelist = _removelist_;
/*  42 */     this.addlist = _addlist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.roleid);
/*  51 */     _os_.compact_uint32(this.removelist.size());
/*  52 */     for (Integer _v_ : this.removelist) {
/*  53 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  55 */     _os_.compact_uint32(this.addlist.size());
/*  56 */     for (Integer _v_ : this.addlist) {
/*  57 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.roleid = _os_.unmarshal_long();
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  66 */       int _v_ = _os_.unmarshal_int();
/*  67 */       this.removelist.add(Integer.valueOf(_v_));
/*     */     }
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  71 */       int _v_ = _os_.unmarshal_int();
/*  72 */       this.addlist.add(Integer.valueOf(_v_));
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SSyncRoleStatusChange)) {
/*  83 */       SSyncRoleStatusChange _o_ = (SSyncRoleStatusChange)_o1_;
/*  84 */       if (this.roleid != _o_.roleid) return false;
/*  85 */       if (!this.removelist.equals(_o_.removelist)) return false;
/*  86 */       if (!this.addlist.equals(_o_.addlist)) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += (int)this.roleid;
/*  95 */     _h_ += this.removelist.hashCode();
/*  96 */     _h_ += this.addlist.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.roleid).append(",");
/* 104 */     _sb_.append(this.removelist).append(",");
/* 105 */     _sb_.append(this.addlist).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SSyncRoleStatusChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */