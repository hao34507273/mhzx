/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SChildrenChangeOccupationRes
/*     */   extends __SChildrenChangeOccupationRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609413;
/*     */   public long childrenid;
/*     */   public int occupation;
/*     */   public HashMap<Integer, Integer> skill2lv;
/*     */   public ArrayList<Integer> fightskills;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609413;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChildrenChangeOccupationRes()
/*     */   {
/*  36 */     this.skill2lv = new HashMap();
/*  37 */     this.fightskills = new ArrayList();
/*     */   }
/*     */   
/*     */   public SChildrenChangeOccupationRes(long _childrenid_, int _occupation_, HashMap<Integer, Integer> _skill2lv_, ArrayList<Integer> _fightskills_) {
/*  41 */     this.childrenid = _childrenid_;
/*  42 */     this.occupation = _occupation_;
/*  43 */     this.skill2lv = _skill2lv_;
/*  44 */     this.fightskills = _fightskills_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.childrenid);
/*  53 */     _os_.marshal(this.occupation);
/*  54 */     _os_.compact_uint32(this.skill2lv.size());
/*  55 */     for (Map.Entry<Integer, Integer> _e_ : this.skill2lv.entrySet()) {
/*  56 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  57 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  59 */     _os_.compact_uint32(this.fightskills.size());
/*  60 */     for (Integer _v_ : this.fightskills) {
/*  61 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.childrenid = _os_.unmarshal_long();
/*  68 */     this.occupation = _os_.unmarshal_int();
/*  69 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  71 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  73 */       int _v_ = _os_.unmarshal_int();
/*  74 */       this.skill2lv.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  76 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  78 */       int _v_ = _os_.unmarshal_int();
/*  79 */       this.fightskills.add(Integer.valueOf(_v_));
/*     */     }
/*  81 */     if (!_validator_()) {
/*  82 */       throw new VerifyError("validator failed");
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  88 */     if (_o1_ == this) return true;
/*  89 */     if ((_o1_ instanceof SChildrenChangeOccupationRes)) {
/*  90 */       SChildrenChangeOccupationRes _o_ = (SChildrenChangeOccupationRes)_o1_;
/*  91 */       if (this.childrenid != _o_.childrenid) return false;
/*  92 */       if (this.occupation != _o_.occupation) return false;
/*  93 */       if (!this.skill2lv.equals(_o_.skill2lv)) return false;
/*  94 */       if (!this.fightskills.equals(_o_.fightskills)) return false;
/*  95 */       return true;
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 101 */     int _h_ = 0;
/* 102 */     _h_ += (int)this.childrenid;
/* 103 */     _h_ += this.occupation;
/* 104 */     _h_ += this.skill2lv.hashCode();
/* 105 */     _h_ += this.fightskills.hashCode();
/* 106 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 110 */     StringBuilder _sb_ = new StringBuilder();
/* 111 */     _sb_.append("(");
/* 112 */     _sb_.append(this.childrenid).append(",");
/* 113 */     _sb_.append(this.occupation).append(",");
/* 114 */     _sb_.append(this.skill2lv).append(",");
/* 115 */     _sb_.append(this.fightskills).append(",");
/* 116 */     _sb_.append(")");
/* 117 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SChildrenChangeOccupationRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */