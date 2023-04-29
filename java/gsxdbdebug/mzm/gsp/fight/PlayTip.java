/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class PlayTip
/*     */   implements Marshal
/*     */ {
/*     */   public static final int SKILL_TARGET_NOT_SUIT = 121000003;
/*     */   public static final int REST_STATUS = 121000004;
/*     */   public static final int WEAK_STATUS = 121000005;
/*     */   public static final int CAPTURE_LEVEL_NOT_ENOUGH = 121000007;
/*     */   public static final int TARGET_NOT_SUIT = 121000012;
/*     */   public static final int PET_BAG_FULL = 121000013;
/*     */   public static final int SEAL_STATUS = 121000019;
/*     */   public static final int STONE_STATUS = 121000020;
/*     */   public static final int SLEEP_STATUS = 121000021;
/*     */   public static final int INVISIABLE_STATUS = 121000022;
/*     */   public static final int ICE_STATUS = 121000014;
/*     */   public static final int CHILD_MESS_STATUS = 121000015;
/*     */   public static final int NEED_HP_RATE_HIGHER = 121000023;
/*     */   public static final int NEED_HP_RATE_LOWER = 121000024;
/*     */   public static final int NEED_MP_RATE_HIGHER = 121000025;
/*     */   public static final int NEED_MP_RATE_LOWER = 121000026;
/*     */   public static final int COST_HP_LOWER = 121000027;
/*     */   public static final int COST_HP_RATE_LOWER = 121000028;
/*     */   public static final int COST_MP_LOWER = 121000029;
/*     */   public static final int COST_MP_RATE_LOWER = 121000030;
/*     */   public static final int COST_ANGER_LOWER = 121000031;
/*     */   public static final int COST_ANGER_RATE_LOWER = 121000032;
/*     */   public static final int SEAL_TARGET_TO_MAX = 121000033;
/*     */   public static final int DRAG_NOT_EXIST = 121000034;
/*     */   public static final int SUMMON_CHILD_NOT_IN_BAG = 121000035;
/*     */   public int fighterid;
/*     */   public int ret;
/*     */   public ArrayList<String> args;
/*     */   
/*     */   public PlayTip()
/*     */   {
/*  42 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public PlayTip(int _fighterid_, int _ret_, ArrayList<String> _args_) {
/*  46 */     this.fighterid = _fighterid_;
/*  47 */     this.ret = _ret_;
/*  48 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.fighterid);
/*  57 */     _os_.marshal(this.ret);
/*  58 */     _os_.compact_uint32(this.args.size());
/*  59 */     for (String _v_ : this.args) {
/*  60 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.fighterid = _os_.unmarshal_int();
/*  67 */     this.ret = _os_.unmarshal_int();
/*  68 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  70 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  71 */       this.args.add(_v_);
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof PlayTip)) {
/*  79 */       PlayTip _o_ = (PlayTip)_o1_;
/*  80 */       if (this.fighterid != _o_.fighterid) return false;
/*  81 */       if (this.ret != _o_.ret) return false;
/*  82 */       if (!this.args.equals(_o_.args)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.fighterid;
/*  91 */     _h_ += this.ret;
/*  92 */     _h_ += this.args.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.fighterid).append(",");
/* 100 */     _sb_.append(this.ret).append(",");
/* 101 */     _sb_.append(this.args).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\PlayTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */