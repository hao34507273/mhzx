/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.drawandguess.main.IDrawAndGuessContext;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.Logs;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class DrawAndGuessInfo extends XBean implements xbean.DrawAndGuessInfo
/*     */ {
/*     */   private IDrawAndGuessContext context;
/*     */   private long session_id;
/*     */   private long start_time;
/*     */   private int cfg_id;
/*     */   private long drawer_id;
/*     */   private ArrayList<Long> all_roleids;
/*     */   private ArrayList<Long> suc_roleids;
/*     */   private HashMap<Long, Long> roleids2answer_time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  32 */     this.context = null;
/*  33 */     this.session_id = -1L;
/*  34 */     this.start_time = -1L;
/*  35 */     this.cfg_id = 0;
/*  36 */     this.drawer_id = 0L;
/*  37 */     this.all_roleids.clear();
/*  38 */     this.suc_roleids.clear();
/*  39 */     this.roleids2answer_time.clear();
/*     */   }
/*     */   
/*     */   DrawAndGuessInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     this.context = null;
/*  46 */     this.session_id = -1L;
/*  47 */     this.start_time = -1L;
/*  48 */     this.cfg_id = 0;
/*  49 */     this.drawer_id = 0L;
/*  50 */     this.all_roleids = new ArrayList();
/*  51 */     this.suc_roleids = new ArrayList();
/*  52 */     this.roleids2answer_time = new HashMap();
/*     */   }
/*     */   
/*     */   public DrawAndGuessInfo()
/*     */   {
/*  57 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public DrawAndGuessInfo(DrawAndGuessInfo _o_)
/*     */   {
/*  62 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   DrawAndGuessInfo(xbean.DrawAndGuessInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  67 */     super(_xp_, _vn_);
/*  68 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  86 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  98 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DrawAndGuessInfo copy()
/*     */   {
/* 104 */     _xdb_verify_unsafe_();
/* 105 */     return new DrawAndGuessInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DrawAndGuessInfo toData()
/*     */   {
/* 111 */     _xdb_verify_unsafe_();
/* 112 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DrawAndGuessInfo toBean()
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/* 118 */     return new DrawAndGuessInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DrawAndGuessInfo toDataIf()
/*     */   {
/* 124 */     _xdb_verify_unsafe_();
/* 125 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DrawAndGuessInfo toBeanIf()
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/* 131 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public IDrawAndGuessContext getContext()
/*     */   {
/* 145 */     _xdb_verify_unsafe_();
/* 146 */     return this.context;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSession_id()
/*     */   {
/* 153 */     _xdb_verify_unsafe_();
/* 154 */     return this.session_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStart_time()
/*     */   {
/* 161 */     _xdb_verify_unsafe_();
/* 162 */     return this.start_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCfg_id()
/*     */   {
/* 169 */     _xdb_verify_unsafe_();
/* 170 */     return this.cfg_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getDrawer_id()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return this.drawer_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getAll_roleids()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return Logs.logList(new LogKey(this, "all_roleids"), this.all_roleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getAll_roleidsAsData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/*     */     
/* 194 */     DrawAndGuessInfo _o_ = this;
/* 195 */     List<Long> all_roleids = new ArrayList();
/* 196 */     all_roleids.addAll(_o_.all_roleids);
/* 197 */     return all_roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getSuc_roleids()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return Logs.logList(new LogKey(this, "suc_roleids"), this.suc_roleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getSuc_roleidsAsData()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/*     */     
/* 213 */     DrawAndGuessInfo _o_ = this;
/* 214 */     List<Long> suc_roleids = new ArrayList();
/* 215 */     suc_roleids.addAll(_o_.suc_roleids);
/* 216 */     return suc_roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Long> getRoleids2answer_time()
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     return Logs.logMap(new LogKey(this, "roleids2answer_time"), this.roleids2answer_time);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Long> getRoleids2answer_timeAsData()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/*     */     
/* 233 */     DrawAndGuessInfo _o_ = this;
/* 234 */     Map<Long, Long> roleids2answer_time = new HashMap();
/* 235 */     for (java.util.Map.Entry<Long, Long> _e_ : _o_.roleids2answer_time.entrySet())
/* 236 */       roleids2answer_time.put(_e_.getKey(), _e_.getValue());
/* 237 */     return roleids2answer_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContext(IDrawAndGuessContext _v_)
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     Logs.logIf(new LogKey(this, "context")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 249 */         new xdb.logs.LogObject(this, DrawAndGuessInfo.this.context)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 253 */             DrawAndGuessInfo.this.context = ((IDrawAndGuessContext)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 257 */     });
/* 258 */     this.context = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSession_id(long _v_)
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     Logs.logIf(new LogKey(this, "session_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 270 */         new LogLong(this, DrawAndGuessInfo.this.session_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 274 */             DrawAndGuessInfo.this.session_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 278 */     });
/* 279 */     this.session_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStart_time(long _v_)
/*     */   {
/* 286 */     _xdb_verify_unsafe_();
/* 287 */     Logs.logIf(new LogKey(this, "start_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 291 */         new LogLong(this, DrawAndGuessInfo.this.start_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 295 */             DrawAndGuessInfo.this.start_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 299 */     });
/* 300 */     this.start_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCfg_id(int _v_)
/*     */   {
/* 307 */     _xdb_verify_unsafe_();
/* 308 */     Logs.logIf(new LogKey(this, "cfg_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 312 */         new xdb.logs.LogInt(this, DrawAndGuessInfo.this.cfg_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 316 */             DrawAndGuessInfo.this.cfg_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 320 */     });
/* 321 */     this.cfg_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDrawer_id(long _v_)
/*     */   {
/* 328 */     _xdb_verify_unsafe_();
/* 329 */     Logs.logIf(new LogKey(this, "drawer_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 333 */         new LogLong(this, DrawAndGuessInfo.this.drawer_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 337 */             DrawAndGuessInfo.this.drawer_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 341 */     });
/* 342 */     this.drawer_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 348 */     _xdb_verify_unsafe_();
/* 349 */     DrawAndGuessInfo _o_ = null;
/* 350 */     if ((_o1_ instanceof DrawAndGuessInfo)) { _o_ = (DrawAndGuessInfo)_o1_;
/* 351 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 352 */       return false;
/* 353 */     if (((null == this.context) && (null != _o_.context)) || ((null != this.context) && (null == _o_.context)) || ((null != this.context) && (null != _o_.context) && (!this.context.equals(_o_.context)))) return false;
/* 354 */     if (this.session_id != _o_.session_id) return false;
/* 355 */     if (this.start_time != _o_.start_time) return false;
/* 356 */     if (this.cfg_id != _o_.cfg_id) return false;
/* 357 */     if (this.drawer_id != _o_.drawer_id) return false;
/* 358 */     if (!this.all_roleids.equals(_o_.all_roleids)) return false;
/* 359 */     if (!this.suc_roleids.equals(_o_.suc_roleids)) return false;
/* 360 */     if (!this.roleids2answer_time.equals(_o_.roleids2answer_time)) return false;
/* 361 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 367 */     _xdb_verify_unsafe_();
/* 368 */     int _h_ = 0;
/* 369 */     _h_ += (this.context == null ? 0 : this.context.hashCode());
/* 370 */     _h_ = (int)(_h_ + this.session_id);
/* 371 */     _h_ = (int)(_h_ + this.start_time);
/* 372 */     _h_ += this.cfg_id;
/* 373 */     _h_ = (int)(_h_ + this.drawer_id);
/* 374 */     _h_ += this.all_roleids.hashCode();
/* 375 */     _h_ += this.suc_roleids.hashCode();
/* 376 */     _h_ += this.roleids2answer_time.hashCode();
/* 377 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 383 */     _xdb_verify_unsafe_();
/* 384 */     StringBuilder _sb_ = new StringBuilder();
/* 385 */     _sb_.append("(");
/* 386 */     _sb_.append(this.context);
/* 387 */     _sb_.append(",");
/* 388 */     _sb_.append(this.session_id);
/* 389 */     _sb_.append(",");
/* 390 */     _sb_.append(this.start_time);
/* 391 */     _sb_.append(",");
/* 392 */     _sb_.append(this.cfg_id);
/* 393 */     _sb_.append(",");
/* 394 */     _sb_.append(this.drawer_id);
/* 395 */     _sb_.append(",");
/* 396 */     _sb_.append(this.all_roleids);
/* 397 */     _sb_.append(",");
/* 398 */     _sb_.append(this.suc_roleids);
/* 399 */     _sb_.append(",");
/* 400 */     _sb_.append(this.roleids2answer_time);
/* 401 */     _sb_.append(")");
/* 402 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 408 */     ListenableBean lb = new ListenableBean();
/* 409 */     lb.add(new ListenableChanged().setVarName("context"));
/* 410 */     lb.add(new ListenableChanged().setVarName("session_id"));
/* 411 */     lb.add(new ListenableChanged().setVarName("start_time"));
/* 412 */     lb.add(new ListenableChanged().setVarName("cfg_id"));
/* 413 */     lb.add(new ListenableChanged().setVarName("drawer_id"));
/* 414 */     lb.add(new ListenableChanged().setVarName("all_roleids"));
/* 415 */     lb.add(new ListenableChanged().setVarName("suc_roleids"));
/* 416 */     lb.add(new xdb.logs.ListenableMap().setVarName("roleids2answer_time"));
/* 417 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.DrawAndGuessInfo {
/*     */     private Const() {}
/*     */     
/*     */     DrawAndGuessInfo nThis() {
/* 424 */       return DrawAndGuessInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 430 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawAndGuessInfo copy()
/*     */     {
/* 436 */       return DrawAndGuessInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawAndGuessInfo toData()
/*     */     {
/* 442 */       return DrawAndGuessInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.DrawAndGuessInfo toBean()
/*     */     {
/* 447 */       return DrawAndGuessInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawAndGuessInfo toDataIf()
/*     */     {
/* 453 */       return DrawAndGuessInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.DrawAndGuessInfo toBeanIf()
/*     */     {
/* 458 */       return DrawAndGuessInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public IDrawAndGuessContext getContext()
/*     */     {
/* 465 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 466 */       return DrawAndGuessInfo.this.context;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSession_id()
/*     */     {
/* 473 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 474 */       return DrawAndGuessInfo.this.session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStart_time()
/*     */     {
/* 481 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 482 */       return DrawAndGuessInfo.this.start_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCfg_id()
/*     */     {
/* 489 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 490 */       return DrawAndGuessInfo.this.cfg_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getDrawer_id()
/*     */     {
/* 497 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 498 */       return DrawAndGuessInfo.this.drawer_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAll_roleids()
/*     */     {
/* 505 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 506 */       return xdb.Consts.constList(DrawAndGuessInfo.this.all_roleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getAll_roleidsAsData()
/*     */     {
/* 512 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/*     */       
/* 514 */       DrawAndGuessInfo _o_ = DrawAndGuessInfo.this;
/* 515 */       List<Long> all_roleids = new ArrayList();
/* 516 */       all_roleids.addAll(_o_.all_roleids);
/* 517 */       return all_roleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getSuc_roleids()
/*     */     {
/* 524 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 525 */       return xdb.Consts.constList(DrawAndGuessInfo.this.suc_roleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getSuc_roleidsAsData()
/*     */     {
/* 531 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/*     */       
/* 533 */       DrawAndGuessInfo _o_ = DrawAndGuessInfo.this;
/* 534 */       List<Long> suc_roleids = new ArrayList();
/* 535 */       suc_roleids.addAll(_o_.suc_roleids);
/* 536 */       return suc_roleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Long> getRoleids2answer_time()
/*     */     {
/* 543 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 544 */       return xdb.Consts.constMap(DrawAndGuessInfo.this.roleids2answer_time);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Long> getRoleids2answer_timeAsData()
/*     */     {
/* 551 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/*     */       
/* 553 */       DrawAndGuessInfo _o_ = DrawAndGuessInfo.this;
/* 554 */       Map<Long, Long> roleids2answer_time = new HashMap();
/* 555 */       for (java.util.Map.Entry<Long, Long> _e_ : _o_.roleids2answer_time.entrySet())
/* 556 */         roleids2answer_time.put(_e_.getKey(), _e_.getValue());
/* 557 */       return roleids2answer_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContext(IDrawAndGuessContext _v_)
/*     */     {
/* 564 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 565 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSession_id(long _v_)
/*     */     {
/* 572 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 573 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStart_time(long _v_)
/*     */     {
/* 580 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 581 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCfg_id(int _v_)
/*     */     {
/* 588 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 589 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDrawer_id(long _v_)
/*     */     {
/* 596 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 597 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 603 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 604 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 610 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 611 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 617 */       return DrawAndGuessInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 623 */       return DrawAndGuessInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 629 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 630 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 636 */       return DrawAndGuessInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 642 */       return DrawAndGuessInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 648 */       DrawAndGuessInfo.this._xdb_verify_unsafe_();
/* 649 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 655 */       return DrawAndGuessInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 661 */       return DrawAndGuessInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 667 */       return DrawAndGuessInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 673 */       return DrawAndGuessInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 679 */       return DrawAndGuessInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 685 */       return DrawAndGuessInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 691 */       return DrawAndGuessInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.DrawAndGuessInfo
/*     */   {
/*     */     private IDrawAndGuessContext context;
/*     */     
/*     */     private long session_id;
/*     */     
/*     */     private long start_time;
/*     */     
/*     */     private int cfg_id;
/*     */     
/*     */     private long drawer_id;
/*     */     
/*     */     private ArrayList<Long> all_roleids;
/*     */     
/*     */     private ArrayList<Long> suc_roleids;
/*     */     
/*     */     private HashMap<Long, Long> roleids2answer_time;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 717 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 722 */       this.context = null;
/* 723 */       this.session_id = -1L;
/* 724 */       this.start_time = -1L;
/* 725 */       this.cfg_id = 0;
/* 726 */       this.drawer_id = 0L;
/* 727 */       this.all_roleids = new ArrayList();
/* 728 */       this.suc_roleids = new ArrayList();
/* 729 */       this.roleids2answer_time = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.DrawAndGuessInfo _o1_)
/*     */     {
/* 734 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 740 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 746 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 752 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 758 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 764 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawAndGuessInfo copy()
/*     */     {
/* 770 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawAndGuessInfo toData()
/*     */     {
/* 776 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.DrawAndGuessInfo toBean()
/*     */     {
/* 781 */       return new DrawAndGuessInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawAndGuessInfo toDataIf()
/*     */     {
/* 787 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.DrawAndGuessInfo toBeanIf()
/*     */     {
/* 792 */       return new DrawAndGuessInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 798 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 802 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 806 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 810 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 814 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 818 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 822 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public IDrawAndGuessContext getContext()
/*     */     {
/* 829 */       return this.context;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSession_id()
/*     */     {
/* 836 */       return this.session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStart_time()
/*     */     {
/* 843 */       return this.start_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCfg_id()
/*     */     {
/* 850 */       return this.cfg_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getDrawer_id()
/*     */     {
/* 857 */       return this.drawer_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAll_roleids()
/*     */     {
/* 864 */       return this.all_roleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAll_roleidsAsData()
/*     */     {
/* 871 */       return this.all_roleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getSuc_roleids()
/*     */     {
/* 878 */       return this.suc_roleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getSuc_roleidsAsData()
/*     */     {
/* 885 */       return this.suc_roleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Long> getRoleids2answer_time()
/*     */     {
/* 892 */       return this.roleids2answer_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Long> getRoleids2answer_timeAsData()
/*     */     {
/* 899 */       return this.roleids2answer_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContext(IDrawAndGuessContext _v_)
/*     */     {
/* 906 */       this.context = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSession_id(long _v_)
/*     */     {
/* 913 */       this.session_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStart_time(long _v_)
/*     */     {
/* 920 */       this.start_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCfg_id(int _v_)
/*     */     {
/* 927 */       this.cfg_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDrawer_id(long _v_)
/*     */     {
/* 934 */       this.drawer_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 940 */       if (!(_o1_ instanceof Data)) return false;
/* 941 */       Data _o_ = (Data)_o1_;
/* 942 */       if (((null == this.context) && (null != _o_.context)) || ((null != this.context) && (null == _o_.context)) || ((null != this.context) && (null != _o_.context) && (!this.context.equals(_o_.context)))) return false;
/* 943 */       if (this.session_id != _o_.session_id) return false;
/* 944 */       if (this.start_time != _o_.start_time) return false;
/* 945 */       if (this.cfg_id != _o_.cfg_id) return false;
/* 946 */       if (this.drawer_id != _o_.drawer_id) return false;
/* 947 */       if (!this.all_roleids.equals(_o_.all_roleids)) return false;
/* 948 */       if (!this.suc_roleids.equals(_o_.suc_roleids)) return false;
/* 949 */       if (!this.roleids2answer_time.equals(_o_.roleids2answer_time)) return false;
/* 950 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 956 */       int _h_ = 0;
/* 957 */       _h_ += (this.context == null ? 0 : this.context.hashCode());
/* 958 */       _h_ = (int)(_h_ + this.session_id);
/* 959 */       _h_ = (int)(_h_ + this.start_time);
/* 960 */       _h_ += this.cfg_id;
/* 961 */       _h_ = (int)(_h_ + this.drawer_id);
/* 962 */       _h_ += this.all_roleids.hashCode();
/* 963 */       _h_ += this.suc_roleids.hashCode();
/* 964 */       _h_ += this.roleids2answer_time.hashCode();
/* 965 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 971 */       StringBuilder _sb_ = new StringBuilder();
/* 972 */       _sb_.append("(");
/* 973 */       _sb_.append(this.context);
/* 974 */       _sb_.append(",");
/* 975 */       _sb_.append(this.session_id);
/* 976 */       _sb_.append(",");
/* 977 */       _sb_.append(this.start_time);
/* 978 */       _sb_.append(",");
/* 979 */       _sb_.append(this.cfg_id);
/* 980 */       _sb_.append(",");
/* 981 */       _sb_.append(this.drawer_id);
/* 982 */       _sb_.append(",");
/* 983 */       _sb_.append(this.all_roleids);
/* 984 */       _sb_.append(",");
/* 985 */       _sb_.append(this.suc_roleids);
/* 986 */       _sb_.append(",");
/* 987 */       _sb_.append(this.roleids2answer_time);
/* 988 */       _sb_.append(")");
/* 989 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DrawAndGuessInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */