/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xbean.RoleWordQuestionInfo;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class WordQuestionInfo extends XBean implements xbean.WordQuestionInfo
/*     */ {
/*     */   private HashMap<Long, RoleWordQuestionInfo> rolequestionmap;
/*     */   private int levelcfgid;
/*     */   private Object attachobject;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.rolequestionmap.clear();
/*  23 */     this.levelcfgid = 0;
/*  24 */     this.attachobject = null;
/*     */   }
/*     */   
/*     */   WordQuestionInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.rolequestionmap = new HashMap();
/*  31 */     this.attachobject = null;
/*     */   }
/*     */   
/*     */   public WordQuestionInfo()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public WordQuestionInfo(WordQuestionInfo _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   WordQuestionInfo(xbean.WordQuestionInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  53 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  59 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  65 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  71 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  77 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WordQuestionInfo copy()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     return new WordQuestionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WordQuestionInfo toData()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.WordQuestionInfo toBean()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     return new WordQuestionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WordQuestionInfo toDataIf()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.WordQuestionInfo toBeanIf()
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/* 110 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/* 117 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, RoleWordQuestionInfo> getRolequestionmap()
/*     */   {
/* 124 */     _xdb_verify_unsafe_();
/* 125 */     return xdb.Logs.logMap(new LogKey(this, "rolequestionmap"), this.rolequestionmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, RoleWordQuestionInfo> getRolequestionmapAsData()
/*     */   {
/* 132 */     _xdb_verify_unsafe_();
/*     */     
/* 134 */     WordQuestionInfo _o_ = this;
/* 135 */     Map<Long, RoleWordQuestionInfo> rolequestionmap = new HashMap();
/* 136 */     for (Map.Entry<Long, RoleWordQuestionInfo> _e_ : _o_.rolequestionmap.entrySet())
/* 137 */       rolequestionmap.put(_e_.getKey(), new RoleWordQuestionInfo.Data((RoleWordQuestionInfo)_e_.getValue()));
/* 138 */     return rolequestionmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getLevelcfgid()
/*     */   {
/* 145 */     _xdb_verify_unsafe_();
/* 146 */     return this.levelcfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Object getAttachobject()
/*     */   {
/* 153 */     _xdb_verify_unsafe_();
/* 154 */     return this.attachobject;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLevelcfgid(int _v_)
/*     */   {
/* 161 */     _xdb_verify_unsafe_();
/* 162 */     xdb.Logs.logIf(new LogKey(this, "levelcfgid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 166 */         new xdb.logs.LogInt(this, WordQuestionInfo.this.levelcfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 170 */             WordQuestionInfo.this.levelcfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 174 */     });
/* 175 */     this.levelcfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAttachobject(Object _v_)
/*     */   {
/* 182 */     _xdb_verify_unsafe_();
/* 183 */     xdb.Logs.logIf(new LogKey(this, "attachobject")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 187 */         new xdb.logs.LogObject(this, WordQuestionInfo.this.attachobject)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 191 */             WordQuestionInfo.this.attachobject = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 195 */     });
/* 196 */     this.attachobject = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 202 */     _xdb_verify_unsafe_();
/* 203 */     WordQuestionInfo _o_ = null;
/* 204 */     if ((_o1_ instanceof WordQuestionInfo)) { _o_ = (WordQuestionInfo)_o1_;
/* 205 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 206 */       return false;
/* 207 */     if (!this.rolequestionmap.equals(_o_.rolequestionmap)) return false;
/* 208 */     if (this.levelcfgid != _o_.levelcfgid) return false;
/* 209 */     if (((null == this.attachobject) && (null != _o_.attachobject)) || ((null != this.attachobject) && (null == _o_.attachobject)) || ((null != this.attachobject) && (null != _o_.attachobject) && (!this.attachobject.equals(_o_.attachobject)))) return false;
/* 210 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 216 */     _xdb_verify_unsafe_();
/* 217 */     int _h_ = 0;
/* 218 */     _h_ += this.rolequestionmap.hashCode();
/* 219 */     _h_ += this.levelcfgid;
/* 220 */     _h_ += (this.attachobject == null ? 0 : this.attachobject.hashCode());
/* 221 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     StringBuilder _sb_ = new StringBuilder();
/* 229 */     _sb_.append("(");
/* 230 */     _sb_.append(this.rolequestionmap);
/* 231 */     _sb_.append(",");
/* 232 */     _sb_.append(this.levelcfgid);
/* 233 */     _sb_.append(",");
/* 234 */     _sb_.append(this.attachobject);
/* 235 */     _sb_.append(")");
/* 236 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 242 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 243 */     lb.add(new xdb.logs.ListenableMap().setVarName("rolequestionmap"));
/* 244 */     lb.add(new xdb.logs.ListenableChanged().setVarName("levelcfgid"));
/* 245 */     lb.add(new xdb.logs.ListenableChanged().setVarName("attachobject"));
/* 246 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.WordQuestionInfo {
/*     */     private Const() {}
/*     */     
/*     */     WordQuestionInfo nThis() {
/* 253 */       return WordQuestionInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 259 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WordQuestionInfo copy()
/*     */     {
/* 265 */       return WordQuestionInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WordQuestionInfo toData()
/*     */     {
/* 271 */       return WordQuestionInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.WordQuestionInfo toBean()
/*     */     {
/* 276 */       return WordQuestionInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WordQuestionInfo toDataIf()
/*     */     {
/* 282 */       return WordQuestionInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.WordQuestionInfo toBeanIf()
/*     */     {
/* 287 */       return WordQuestionInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, RoleWordQuestionInfo> getRolequestionmap()
/*     */     {
/* 294 */       WordQuestionInfo.this._xdb_verify_unsafe_();
/* 295 */       return xdb.Consts.constMap(WordQuestionInfo.this.rolequestionmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, RoleWordQuestionInfo> getRolequestionmapAsData()
/*     */     {
/* 302 */       WordQuestionInfo.this._xdb_verify_unsafe_();
/*     */       
/* 304 */       WordQuestionInfo _o_ = WordQuestionInfo.this;
/* 305 */       Map<Long, RoleWordQuestionInfo> rolequestionmap = new HashMap();
/* 306 */       for (Map.Entry<Long, RoleWordQuestionInfo> _e_ : _o_.rolequestionmap.entrySet())
/* 307 */         rolequestionmap.put(_e_.getKey(), new RoleWordQuestionInfo.Data((RoleWordQuestionInfo)_e_.getValue()));
/* 308 */       return rolequestionmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevelcfgid()
/*     */     {
/* 315 */       WordQuestionInfo.this._xdb_verify_unsafe_();
/* 316 */       return WordQuestionInfo.this.levelcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Object getAttachobject()
/*     */     {
/* 323 */       WordQuestionInfo.this._xdb_verify_unsafe_();
/* 324 */       return WordQuestionInfo.this.attachobject;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevelcfgid(int _v_)
/*     */     {
/* 331 */       WordQuestionInfo.this._xdb_verify_unsafe_();
/* 332 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAttachobject(Object _v_)
/*     */     {
/* 339 */       WordQuestionInfo.this._xdb_verify_unsafe_();
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 346 */       WordQuestionInfo.this._xdb_verify_unsafe_();
/* 347 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 353 */       WordQuestionInfo.this._xdb_verify_unsafe_();
/* 354 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 360 */       return WordQuestionInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 366 */       return WordQuestionInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 372 */       WordQuestionInfo.this._xdb_verify_unsafe_();
/* 373 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 379 */       return WordQuestionInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 385 */       return WordQuestionInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 391 */       WordQuestionInfo.this._xdb_verify_unsafe_();
/* 392 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 398 */       return WordQuestionInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 404 */       return WordQuestionInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 410 */       return WordQuestionInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 416 */       return WordQuestionInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 422 */       return WordQuestionInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 428 */       return WordQuestionInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 434 */       return WordQuestionInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.WordQuestionInfo
/*     */   {
/*     */     private HashMap<Long, RoleWordQuestionInfo> rolequestionmap;
/*     */     
/*     */     private int levelcfgid;
/*     */     
/*     */     private Object attachobject;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 450 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 455 */       this.rolequestionmap = new HashMap();
/* 456 */       this.attachobject = null;
/*     */     }
/*     */     
/*     */     Data(xbean.WordQuestionInfo _o1_)
/*     */     {
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 473 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 485 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 491 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WordQuestionInfo copy()
/*     */     {
/* 497 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WordQuestionInfo toData()
/*     */     {
/* 503 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.WordQuestionInfo toBean()
/*     */     {
/* 508 */       return new WordQuestionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WordQuestionInfo toDataIf()
/*     */     {
/* 514 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.WordQuestionInfo toBeanIf()
/*     */     {
/* 519 */       return new WordQuestionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 529 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 533 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 537 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 545 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 549 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, RoleWordQuestionInfo> getRolequestionmap()
/*     */     {
/* 556 */       return this.rolequestionmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, RoleWordQuestionInfo> getRolequestionmapAsData()
/*     */     {
/* 563 */       return this.rolequestionmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevelcfgid()
/*     */     {
/* 570 */       return this.levelcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Object getAttachobject()
/*     */     {
/* 577 */       return this.attachobject;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevelcfgid(int _v_)
/*     */     {
/* 584 */       this.levelcfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAttachobject(Object _v_)
/*     */     {
/* 591 */       this.attachobject = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 597 */       if (!(_o1_ instanceof Data)) return false;
/* 598 */       Data _o_ = (Data)_o1_;
/* 599 */       if (!this.rolequestionmap.equals(_o_.rolequestionmap)) return false;
/* 600 */       if (this.levelcfgid != _o_.levelcfgid) return false;
/* 601 */       if (((null == this.attachobject) && (null != _o_.attachobject)) || ((null != this.attachobject) && (null == _o_.attachobject)) || ((null != this.attachobject) && (null != _o_.attachobject) && (!this.attachobject.equals(_o_.attachobject)))) return false;
/* 602 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 608 */       int _h_ = 0;
/* 609 */       _h_ += this.rolequestionmap.hashCode();
/* 610 */       _h_ += this.levelcfgid;
/* 611 */       _h_ += (this.attachobject == null ? 0 : this.attachobject.hashCode());
/* 612 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 618 */       StringBuilder _sb_ = new StringBuilder();
/* 619 */       _sb_.append("(");
/* 620 */       _sb_.append(this.rolequestionmap);
/* 621 */       _sb_.append(",");
/* 622 */       _sb_.append(this.levelcfgid);
/* 623 */       _sb_.append(",");
/* 624 */       _sb_.append(this.attachobject);
/* 625 */       _sb_.append(")");
/* 626 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\WordQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */