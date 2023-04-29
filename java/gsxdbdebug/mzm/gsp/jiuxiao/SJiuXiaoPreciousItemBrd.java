/*     */ package mzm.gsp.jiuxiao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SJiuXiaoPreciousItemBrd
/*     */   extends __SJiuXiaoPreciousItemBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12595476;
/*     */   public String rolename;
/*     */   public int npcid;
/*     */   public int activityid;
/*     */   public HashMap<Integer, Integer> item2num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12595476;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SJiuXiaoPreciousItemBrd()
/*     */   {
/*  36 */     this.rolename = "";
/*  37 */     this.item2num = new HashMap();
/*     */   }
/*     */   
/*     */   public SJiuXiaoPreciousItemBrd(String _rolename_, int _npcid_, int _activityid_, HashMap<Integer, Integer> _item2num_) {
/*  41 */     this.rolename = _rolename_;
/*  42 */     this.npcid = _npcid_;
/*  43 */     this.activityid = _activityid_;
/*  44 */     this.item2num = _item2num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  53 */     _os_.marshal(this.npcid);
/*  54 */     _os_.marshal(this.activityid);
/*  55 */     _os_.compact_uint32(this.item2num.size());
/*  56 */     for (Map.Entry<Integer, Integer> _e_ : this.item2num.entrySet()) {
/*  57 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  58 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  65 */     this.npcid = _os_.unmarshal_int();
/*  66 */     this.activityid = _os_.unmarshal_int();
/*  67 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  69 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  71 */       int _v_ = _os_.unmarshal_int();
/*  72 */       this.item2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SJiuXiaoPreciousItemBrd)) {
/*  83 */       SJiuXiaoPreciousItemBrd _o_ = (SJiuXiaoPreciousItemBrd)_o1_;
/*  84 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  85 */       if (this.npcid != _o_.npcid) return false;
/*  86 */       if (this.activityid != _o_.activityid) return false;
/*  87 */       if (!this.item2num.equals(_o_.item2num)) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.rolename.hashCode();
/*  96 */     _h_ += this.npcid;
/*  97 */     _h_ += this.activityid;
/*  98 */     _h_ += this.item2num.hashCode();
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 106 */     _sb_.append(this.npcid).append(",");
/* 107 */     _sb_.append(this.activityid).append(",");
/* 108 */     _sb_.append(this.item2num).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\SJiuXiaoPreciousItemBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */