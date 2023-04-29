/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.paraselene.event.JigsawContext;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.Logs;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class JigsawInfo extends XBean implements xbean.JigsawInfo
/*     */ {
/*     */   private JigsawContext context;
/*     */   private long endtime;
/*     */   private int cfgid;
/*     */   private ArrayList<Long> allroleids;
/*     */   private ArrayList<Long> sucroleids;
/*     */   private ArrayList<Long> failroleids;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  28 */     this.context = null;
/*  29 */     this.endtime = -1L;
/*  30 */     this.cfgid = 0;
/*  31 */     this.allroleids.clear();
/*  32 */     this.sucroleids.clear();
/*  33 */     this.failroleids.clear();
/*     */   }
/*     */   
/*     */   JigsawInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  38 */     super(_xp_, _vn_);
/*  39 */     this.context = null;
/*  40 */     this.endtime = -1L;
/*  41 */     this.cfgid = 0;
/*  42 */     this.allroleids = new ArrayList();
/*  43 */     this.sucroleids = new ArrayList();
/*  44 */     this.failroleids = new ArrayList();
/*     */   }
/*     */   
/*     */   public JigsawInfo()
/*     */   {
/*  49 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public JigsawInfo(JigsawInfo _o_)
/*     */   {
/*  54 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   JigsawInfo(xbean.JigsawInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  59 */     super(_xp_, _vn_);
/*  60 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  78 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  84 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  90 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.JigsawInfo copy()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     return new JigsawInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.JigsawInfo toData()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.JigsawInfo toBean()
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/* 110 */     return new JigsawInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.JigsawInfo toDataIf()
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/* 117 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.JigsawInfo toBeanIf()
/*     */   {
/* 122 */     _xdb_verify_unsafe_();
/* 123 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 129 */     _xdb_verify_unsafe_();
/* 130 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public JigsawContext getContext()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     return this.context;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getEndtime()
/*     */   {
/* 145 */     _xdb_verify_unsafe_();
/* 146 */     return this.endtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCfgid()
/*     */   {
/* 153 */     _xdb_verify_unsafe_();
/* 154 */     return this.cfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getAllroleids()
/*     */   {
/* 161 */     _xdb_verify_unsafe_();
/* 162 */     return Logs.logList(new LogKey(this, "allroleids"), this.allroleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getAllroleidsAsData()
/*     */   {
/* 168 */     _xdb_verify_unsafe_();
/*     */     
/* 170 */     JigsawInfo _o_ = this;
/* 171 */     List<Long> allroleids = new ArrayList();
/* 172 */     allroleids.addAll(_o_.allroleids);
/* 173 */     return allroleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getSucroleids()
/*     */   {
/* 180 */     _xdb_verify_unsafe_();
/* 181 */     return Logs.logList(new LogKey(this, "sucroleids"), this.sucroleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getSucroleidsAsData()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/*     */     
/* 189 */     JigsawInfo _o_ = this;
/* 190 */     List<Long> sucroleids = new ArrayList();
/* 191 */     sucroleids.addAll(_o_.sucroleids);
/* 192 */     return sucroleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getFailroleids()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return Logs.logList(new LogKey(this, "failroleids"), this.failroleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getFailroleidsAsData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/*     */     
/* 208 */     JigsawInfo _o_ = this;
/* 209 */     List<Long> failroleids = new ArrayList();
/* 210 */     failroleids.addAll(_o_.failroleids);
/* 211 */     return failroleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContext(JigsawContext _v_)
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     Logs.logIf(new LogKey(this, "context")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 223 */         new xdb.logs.LogObject(this, JigsawInfo.this.context)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 227 */             JigsawInfo.this.context = ((JigsawContext)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 231 */     });
/* 232 */     this.context = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEndtime(long _v_)
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     Logs.logIf(new LogKey(this, "endtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 244 */         new xdb.logs.LogLong(this, JigsawInfo.this.endtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 248 */             JigsawInfo.this.endtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 252 */     });
/* 253 */     this.endtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCfgid(int _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     Logs.logIf(new LogKey(this, "cfgid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new xdb.logs.LogInt(this, JigsawInfo.this.cfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             JigsawInfo.this.cfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.cfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     JigsawInfo _o_ = null;
/* 282 */     if ((_o1_ instanceof JigsawInfo)) { _o_ = (JigsawInfo)_o1_;
/* 283 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 284 */       return false;
/* 285 */     if (((null == this.context) && (null != _o_.context)) || ((null != this.context) && (null == _o_.context)) || ((null != this.context) && (null != _o_.context) && (!this.context.equals(_o_.context)))) return false;
/* 286 */     if (this.endtime != _o_.endtime) return false;
/* 287 */     if (this.cfgid != _o_.cfgid) return false;
/* 288 */     if (!this.allroleids.equals(_o_.allroleids)) return false;
/* 289 */     if (!this.sucroleids.equals(_o_.sucroleids)) return false;
/* 290 */     if (!this.failroleids.equals(_o_.failroleids)) return false;
/* 291 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 297 */     _xdb_verify_unsafe_();
/* 298 */     int _h_ = 0;
/* 299 */     _h_ += (this.context == null ? 0 : this.context.hashCode());
/* 300 */     _h_ = (int)(_h_ + this.endtime);
/* 301 */     _h_ += this.cfgid;
/* 302 */     _h_ += this.allroleids.hashCode();
/* 303 */     _h_ += this.sucroleids.hashCode();
/* 304 */     _h_ += this.failroleids.hashCode();
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.context);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.endtime);
/* 317 */     _sb_.append(",");
/* 318 */     _sb_.append(this.cfgid);
/* 319 */     _sb_.append(",");
/* 320 */     _sb_.append(this.allroleids);
/* 321 */     _sb_.append(",");
/* 322 */     _sb_.append(this.sucroleids);
/* 323 */     _sb_.append(",");
/* 324 */     _sb_.append(this.failroleids);
/* 325 */     _sb_.append(")");
/* 326 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 332 */     ListenableBean lb = new ListenableBean();
/* 333 */     lb.add(new ListenableChanged().setVarName("context"));
/* 334 */     lb.add(new ListenableChanged().setVarName("endtime"));
/* 335 */     lb.add(new ListenableChanged().setVarName("cfgid"));
/* 336 */     lb.add(new ListenableChanged().setVarName("allroleids"));
/* 337 */     lb.add(new ListenableChanged().setVarName("sucroleids"));
/* 338 */     lb.add(new ListenableChanged().setVarName("failroleids"));
/* 339 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.JigsawInfo {
/*     */     private Const() {}
/*     */     
/*     */     JigsawInfo nThis() {
/* 346 */       return JigsawInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 352 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JigsawInfo copy()
/*     */     {
/* 358 */       return JigsawInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JigsawInfo toData()
/*     */     {
/* 364 */       return JigsawInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.JigsawInfo toBean()
/*     */     {
/* 369 */       return JigsawInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JigsawInfo toDataIf()
/*     */     {
/* 375 */       return JigsawInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.JigsawInfo toBeanIf()
/*     */     {
/* 380 */       return JigsawInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public JigsawContext getContext()
/*     */     {
/* 387 */       JigsawInfo.this._xdb_verify_unsafe_();
/* 388 */       return JigsawInfo.this.context;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getEndtime()
/*     */     {
/* 395 */       JigsawInfo.this._xdb_verify_unsafe_();
/* 396 */       return JigsawInfo.this.endtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCfgid()
/*     */     {
/* 403 */       JigsawInfo.this._xdb_verify_unsafe_();
/* 404 */       return JigsawInfo.this.cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAllroleids()
/*     */     {
/* 411 */       JigsawInfo.this._xdb_verify_unsafe_();
/* 412 */       return xdb.Consts.constList(JigsawInfo.this.allroleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getAllroleidsAsData()
/*     */     {
/* 418 */       JigsawInfo.this._xdb_verify_unsafe_();
/*     */       
/* 420 */       JigsawInfo _o_ = JigsawInfo.this;
/* 421 */       List<Long> allroleids = new ArrayList();
/* 422 */       allroleids.addAll(_o_.allroleids);
/* 423 */       return allroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getSucroleids()
/*     */     {
/* 430 */       JigsawInfo.this._xdb_verify_unsafe_();
/* 431 */       return xdb.Consts.constList(JigsawInfo.this.sucroleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getSucroleidsAsData()
/*     */     {
/* 437 */       JigsawInfo.this._xdb_verify_unsafe_();
/*     */       
/* 439 */       JigsawInfo _o_ = JigsawInfo.this;
/* 440 */       List<Long> sucroleids = new ArrayList();
/* 441 */       sucroleids.addAll(_o_.sucroleids);
/* 442 */       return sucroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getFailroleids()
/*     */     {
/* 449 */       JigsawInfo.this._xdb_verify_unsafe_();
/* 450 */       return xdb.Consts.constList(JigsawInfo.this.failroleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getFailroleidsAsData()
/*     */     {
/* 456 */       JigsawInfo.this._xdb_verify_unsafe_();
/*     */       
/* 458 */       JigsawInfo _o_ = JigsawInfo.this;
/* 459 */       List<Long> failroleids = new ArrayList();
/* 460 */       failroleids.addAll(_o_.failroleids);
/* 461 */       return failroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContext(JigsawContext _v_)
/*     */     {
/* 468 */       JigsawInfo.this._xdb_verify_unsafe_();
/* 469 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEndtime(long _v_)
/*     */     {
/* 476 */       JigsawInfo.this._xdb_verify_unsafe_();
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCfgid(int _v_)
/*     */     {
/* 484 */       JigsawInfo.this._xdb_verify_unsafe_();
/* 485 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 491 */       JigsawInfo.this._xdb_verify_unsafe_();
/* 492 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 498 */       JigsawInfo.this._xdb_verify_unsafe_();
/* 499 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 505 */       return JigsawInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 511 */       return JigsawInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 517 */       JigsawInfo.this._xdb_verify_unsafe_();
/* 518 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 524 */       return JigsawInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 530 */       return JigsawInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 536 */       JigsawInfo.this._xdb_verify_unsafe_();
/* 537 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 543 */       return JigsawInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 549 */       return JigsawInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 555 */       return JigsawInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 561 */       return JigsawInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 567 */       return JigsawInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 573 */       return JigsawInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 579 */       return JigsawInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.JigsawInfo
/*     */   {
/*     */     private JigsawContext context;
/*     */     
/*     */     private long endtime;
/*     */     
/*     */     private int cfgid;
/*     */     
/*     */     private ArrayList<Long> allroleids;
/*     */     
/*     */     private ArrayList<Long> sucroleids;
/*     */     
/*     */     private ArrayList<Long> failroleids;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 601 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 606 */       this.context = null;
/* 607 */       this.endtime = -1L;
/* 608 */       this.cfgid = 0;
/* 609 */       this.allroleids = new ArrayList();
/* 610 */       this.sucroleids = new ArrayList();
/* 611 */       this.failroleids = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.JigsawInfo _o1_)
/*     */     {
/* 616 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 622 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 628 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 634 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 640 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 646 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JigsawInfo copy()
/*     */     {
/* 652 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JigsawInfo toData()
/*     */     {
/* 658 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.JigsawInfo toBean()
/*     */     {
/* 663 */       return new JigsawInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JigsawInfo toDataIf()
/*     */     {
/* 669 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.JigsawInfo toBeanIf()
/*     */     {
/* 674 */       return new JigsawInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 680 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 684 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 688 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 692 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 696 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 700 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 704 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public JigsawContext getContext()
/*     */     {
/* 711 */       return this.context;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getEndtime()
/*     */     {
/* 718 */       return this.endtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCfgid()
/*     */     {
/* 725 */       return this.cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAllroleids()
/*     */     {
/* 732 */       return this.allroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAllroleidsAsData()
/*     */     {
/* 739 */       return this.allroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getSucroleids()
/*     */     {
/* 746 */       return this.sucroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getSucroleidsAsData()
/*     */     {
/* 753 */       return this.sucroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getFailroleids()
/*     */     {
/* 760 */       return this.failroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getFailroleidsAsData()
/*     */     {
/* 767 */       return this.failroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContext(JigsawContext _v_)
/*     */     {
/* 774 */       this.context = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEndtime(long _v_)
/*     */     {
/* 781 */       this.endtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCfgid(int _v_)
/*     */     {
/* 788 */       this.cfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 794 */       if (!(_o1_ instanceof Data)) return false;
/* 795 */       Data _o_ = (Data)_o1_;
/* 796 */       if (((null == this.context) && (null != _o_.context)) || ((null != this.context) && (null == _o_.context)) || ((null != this.context) && (null != _o_.context) && (!this.context.equals(_o_.context)))) return false;
/* 797 */       if (this.endtime != _o_.endtime) return false;
/* 798 */       if (this.cfgid != _o_.cfgid) return false;
/* 799 */       if (!this.allroleids.equals(_o_.allroleids)) return false;
/* 800 */       if (!this.sucroleids.equals(_o_.sucroleids)) return false;
/* 801 */       if (!this.failroleids.equals(_o_.failroleids)) return false;
/* 802 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 808 */       int _h_ = 0;
/* 809 */       _h_ += (this.context == null ? 0 : this.context.hashCode());
/* 810 */       _h_ = (int)(_h_ + this.endtime);
/* 811 */       _h_ += this.cfgid;
/* 812 */       _h_ += this.allroleids.hashCode();
/* 813 */       _h_ += this.sucroleids.hashCode();
/* 814 */       _h_ += this.failroleids.hashCode();
/* 815 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 821 */       StringBuilder _sb_ = new StringBuilder();
/* 822 */       _sb_.append("(");
/* 823 */       _sb_.append(this.context);
/* 824 */       _sb_.append(",");
/* 825 */       _sb_.append(this.endtime);
/* 826 */       _sb_.append(",");
/* 827 */       _sb_.append(this.cfgid);
/* 828 */       _sb_.append(",");
/* 829 */       _sb_.append(this.allroleids);
/* 830 */       _sb_.append(",");
/* 831 */       _sb_.append(this.sucroleids);
/* 832 */       _sb_.append(",");
/* 833 */       _sb_.append(this.failroleids);
/* 834 */       _sb_.append(")");
/* 835 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\JigsawInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */