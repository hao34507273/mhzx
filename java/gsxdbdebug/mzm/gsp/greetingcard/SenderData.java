/*     */ package mzm.gsp.greetingcard;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SenderData implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public int gender;
/*     */   public int occupationid;
/*     */   public int level;
/*     */   public int modelid;
/*     */   public ArrayList<Integer> badge;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   
/*     */   public SenderData()
/*     */   {
/*  22 */     this.rolename = "";
/*  23 */     this.badge = new ArrayList();
/*     */   }
/*     */   
/*     */   public SenderData(long _roleid_, String _rolename_, int _gender_, int _occupationid_, int _level_, int _modelid_, ArrayList<Integer> _badge_, int _avatarid_, int _avatarframeid_) {
/*  27 */     this.roleid = _roleid_;
/*  28 */     this.rolename = _rolename_;
/*  29 */     this.gender = _gender_;
/*  30 */     this.occupationid = _occupationid_;
/*  31 */     this.level = _level_;
/*  32 */     this.modelid = _modelid_;
/*  33 */     this.badge = _badge_;
/*  34 */     this.avatarid = _avatarid_;
/*  35 */     this.avatarframeid = _avatarframeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  39 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  43 */     _os_.marshal(this.roleid);
/*  44 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  45 */     _os_.marshal(this.gender);
/*  46 */     _os_.marshal(this.occupationid);
/*  47 */     _os_.marshal(this.level);
/*  48 */     _os_.marshal(this.modelid);
/*  49 */     _os_.compact_uint32(this.badge.size());
/*  50 */     for (Integer _v_ : this.badge) {
/*  51 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  53 */     _os_.marshal(this.avatarid);
/*  54 */     _os_.marshal(this.avatarframeid);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.roleid = _os_.unmarshal_long();
/*  60 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  61 */     this.gender = _os_.unmarshal_int();
/*  62 */     this.occupationid = _os_.unmarshal_int();
/*  63 */     this.level = _os_.unmarshal_int();
/*  64 */     this.modelid = _os_.unmarshal_int();
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  67 */       int _v_ = _os_.unmarshal_int();
/*  68 */       this.badge.add(Integer.valueOf(_v_));
/*     */     }
/*  70 */     this.avatarid = _os_.unmarshal_int();
/*  71 */     this.avatarframeid = _os_.unmarshal_int();
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SenderData)) {
/*  78 */       SenderData _o_ = (SenderData)_o1_;
/*  79 */       if (this.roleid != _o_.roleid) return false;
/*  80 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  81 */       if (this.gender != _o_.gender) return false;
/*  82 */       if (this.occupationid != _o_.occupationid) return false;
/*  83 */       if (this.level != _o_.level) return false;
/*  84 */       if (this.modelid != _o_.modelid) return false;
/*  85 */       if (!this.badge.equals(_o_.badge)) return false;
/*  86 */       if (this.avatarid != _o_.avatarid) return false;
/*  87 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += (int)this.roleid;
/*  96 */     _h_ += this.rolename.hashCode();
/*  97 */     _h_ += this.gender;
/*  98 */     _h_ += this.occupationid;
/*  99 */     _h_ += this.level;
/* 100 */     _h_ += this.modelid;
/* 101 */     _h_ += this.badge.hashCode();
/* 102 */     _h_ += this.avatarid;
/* 103 */     _h_ += this.avatarframeid;
/* 104 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder _sb_ = new StringBuilder();
/* 109 */     _sb_.append("(");
/* 110 */     _sb_.append(this.roleid).append(",");
/* 111 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 112 */     _sb_.append(this.gender).append(",");
/* 113 */     _sb_.append(this.occupationid).append(",");
/* 114 */     _sb_.append(this.level).append(",");
/* 115 */     _sb_.append(this.modelid).append(",");
/* 116 */     _sb_.append(this.badge).append(",");
/* 117 */     _sb_.append(this.avatarid).append(",");
/* 118 */     _sb_.append(this.avatarframeid).append(",");
/* 119 */     _sb_.append(")");
/* 120 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\greetingcard\SenderData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */