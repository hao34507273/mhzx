/*     */ package mzm.gsp.huanhun;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class ItemInfo implements Marshal
/*     */ {
/*     */   public static final int ST_TASK_ING = 0;
/*     */   public static final int ST_TASK_DONE = 1;
/*     */   public static final int ST_HELP__FALSE = 0;
/*     */   public static final int ST_HELP__TRUE = 1;
/*     */   public int itemcfgid;
/*     */   public int awardxiulianexp;
/*     */   public int itemnum;
/*     */   public int taskstate;
/*     */   public int ganghelpstate;
/*     */   public int friendhelpstate;
/*     */   public RoleBaseInfo roleinfo;
/*     */   
/*     */   public ItemInfo()
/*     */   {
/*  23 */     this.roleinfo = new RoleBaseInfo();
/*     */   }
/*     */   
/*     */   public ItemInfo(int _itemcfgid_, int _awardxiulianexp_, int _itemnum_, int _taskstate_, int _ganghelpstate_, int _friendhelpstate_, RoleBaseInfo _roleinfo_) {
/*  27 */     this.itemcfgid = _itemcfgid_;
/*  28 */     this.awardxiulianexp = _awardxiulianexp_;
/*  29 */     this.itemnum = _itemnum_;
/*  30 */     this.taskstate = _taskstate_;
/*  31 */     this.ganghelpstate = _ganghelpstate_;
/*  32 */     this.friendhelpstate = _friendhelpstate_;
/*  33 */     this.roleinfo = _roleinfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  37 */     if (!this.roleinfo._validator_()) return false;
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  42 */     _os_.marshal(this.itemcfgid);
/*  43 */     _os_.marshal(this.awardxiulianexp);
/*  44 */     _os_.marshal(this.itemnum);
/*  45 */     _os_.marshal(this.taskstate);
/*  46 */     _os_.marshal(this.ganghelpstate);
/*  47 */     _os_.marshal(this.friendhelpstate);
/*  48 */     _os_.marshal(this.roleinfo);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.itemcfgid = _os_.unmarshal_int();
/*  54 */     this.awardxiulianexp = _os_.unmarshal_int();
/*  55 */     this.itemnum = _os_.unmarshal_int();
/*  56 */     this.taskstate = _os_.unmarshal_int();
/*  57 */     this.ganghelpstate = _os_.unmarshal_int();
/*  58 */     this.friendhelpstate = _os_.unmarshal_int();
/*  59 */     this.roleinfo.unmarshal(_os_);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  64 */     if (_o1_ == this) return true;
/*  65 */     if ((_o1_ instanceof ItemInfo)) {
/*  66 */       ItemInfo _o_ = (ItemInfo)_o1_;
/*  67 */       if (this.itemcfgid != _o_.itemcfgid) return false;
/*  68 */       if (this.awardxiulianexp != _o_.awardxiulianexp) return false;
/*  69 */       if (this.itemnum != _o_.itemnum) return false;
/*  70 */       if (this.taskstate != _o_.taskstate) return false;
/*  71 */       if (this.ganghelpstate != _o_.ganghelpstate) return false;
/*  72 */       if (this.friendhelpstate != _o_.friendhelpstate) return false;
/*  73 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.itemcfgid;
/*  82 */     _h_ += this.awardxiulianexp;
/*  83 */     _h_ += this.itemnum;
/*  84 */     _h_ += this.taskstate;
/*  85 */     _h_ += this.ganghelpstate;
/*  86 */     _h_ += this.friendhelpstate;
/*  87 */     _h_ += this.roleinfo.hashCode();
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.itemcfgid).append(",");
/*  95 */     _sb_.append(this.awardxiulianexp).append(",");
/*  96 */     _sb_.append(this.itemnum).append(",");
/*  97 */     _sb_.append(this.taskstate).append(",");
/*  98 */     _sb_.append(this.ganghelpstate).append(",");
/*  99 */     _sb_.append(this.friendhelpstate).append(",");
/* 100 */     _sb_.append(this.roleinfo).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\ItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */