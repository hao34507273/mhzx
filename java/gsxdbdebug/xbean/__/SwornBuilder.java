/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import mzm.gsp.sworn.main.SwornWaitSession;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class SwornBuilder extends XBean implements xbean.SwornBuilder
/*      */ {
/*      */   private int status;
/*      */   private long leaderid;
/*      */   private ArrayList<Long> roleids;
/*      */   private ArrayList<Long> agreeids;
/*      */   private long confirmtime;
/*      */   private String name1;
/*      */   private String name2;
/*      */   private HashMap<Long, String> titles;
/*      */   private SwornWaitSession timer;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   34 */     this.status = 0;
/*   35 */     this.leaderid = 0L;
/*   36 */     this.roleids.clear();
/*   37 */     this.agreeids.clear();
/*   38 */     this.confirmtime = 0L;
/*   39 */     this.name1 = "";
/*   40 */     this.name2 = "";
/*   41 */     this.titles.clear();
/*   42 */     this.timer = null;
/*      */   }
/*      */   
/*      */   SwornBuilder(int __, XBean _xp_, String _vn_)
/*      */   {
/*   47 */     super(_xp_, _vn_);
/*   48 */     this.roleids = new ArrayList();
/*   49 */     this.agreeids = new ArrayList();
/*   50 */     this.name1 = "";
/*   51 */     this.name2 = "";
/*   52 */     this.titles = new HashMap();
/*   53 */     this.timer = null;
/*      */   }
/*      */   
/*      */   public SwornBuilder()
/*      */   {
/*   58 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public SwornBuilder(SwornBuilder _o_)
/*      */   {
/*   63 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   SwornBuilder(xbean.SwornBuilder _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   68 */     super(_xp_, _vn_);
/*   69 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   75 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   81 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*   87 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*   93 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*   99 */     throw new UnsupportedOperationException();
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SwornBuilder copy()
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     return new SwornBuilder(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SwornBuilder toData()
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SwornBuilder toBean()
/*      */   {
/*  118 */     _xdb_verify_unsafe_();
/*  119 */     return new SwornBuilder(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SwornBuilder toDataIf()
/*      */   {
/*  125 */     _xdb_verify_unsafe_();
/*  126 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SwornBuilder toBeanIf()
/*      */   {
/*  131 */     _xdb_verify_unsafe_();
/*  132 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  138 */     _xdb_verify_unsafe_();
/*  139 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStatus()
/*      */   {
/*  146 */     _xdb_verify_unsafe_();
/*  147 */     return this.status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLeaderid()
/*      */   {
/*  154 */     _xdb_verify_unsafe_();
/*  155 */     return this.leaderid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getRoleids()
/*      */   {
/*  162 */     _xdb_verify_unsafe_();
/*  163 */     return Logs.logList(new LogKey(this, "roleids"), this.roleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getRoleidsAsData()
/*      */   {
/*  169 */     _xdb_verify_unsafe_();
/*      */     
/*  171 */     SwornBuilder _o_ = this;
/*  172 */     List<Long> roleids = new ArrayList();
/*  173 */     roleids.addAll(_o_.roleids);
/*  174 */     return roleids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getAgreeids()
/*      */   {
/*  181 */     _xdb_verify_unsafe_();
/*  182 */     return Logs.logList(new LogKey(this, "agreeids"), this.agreeids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getAgreeidsAsData()
/*      */   {
/*  188 */     _xdb_verify_unsafe_();
/*      */     
/*  190 */     SwornBuilder _o_ = this;
/*  191 */     List<Long> agreeids = new ArrayList();
/*  192 */     agreeids.addAll(_o_.agreeids);
/*  193 */     return agreeids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getConfirmtime()
/*      */   {
/*  200 */     _xdb_verify_unsafe_();
/*  201 */     return this.confirmtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName1()
/*      */   {
/*  208 */     _xdb_verify_unsafe_();
/*  209 */     return this.name1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getName1Octets()
/*      */   {
/*  216 */     _xdb_verify_unsafe_();
/*  217 */     return Octets.wrap(getName1(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName2()
/*      */   {
/*  224 */     _xdb_verify_unsafe_();
/*  225 */     return this.name2;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getName2Octets()
/*      */   {
/*  232 */     _xdb_verify_unsafe_();
/*  233 */     return Octets.wrap(getName2(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, String> getTitles()
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*  241 */     return Logs.logMap(new LogKey(this, "titles"), this.titles);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, String> getTitlesAsData()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*      */     
/*  250 */     SwornBuilder _o_ = this;
/*  251 */     Map<Long, String> titles = new HashMap();
/*  252 */     for (java.util.Map.Entry<Long, String> _e_ : _o_.titles.entrySet())
/*  253 */       titles.put(_e_.getKey(), _e_.getValue());
/*  254 */     return titles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public SwornWaitSession getTimer()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return this.timer;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStatus(int _v_)
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     Logs.logIf(new LogKey(this, "status")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  274 */         new xdb.logs.LogInt(this, SwornBuilder.this.status)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  278 */             SwornBuilder.this.status = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  282 */     });
/*  283 */     this.status = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLeaderid(long _v_)
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     Logs.logIf(new LogKey(this, "leaderid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  295 */         new xdb.logs.LogLong(this, SwornBuilder.this.leaderid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  299 */             SwornBuilder.this.leaderid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  303 */     });
/*  304 */     this.leaderid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setConfirmtime(long _v_)
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     Logs.logIf(new LogKey(this, "confirmtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  316 */         new xdb.logs.LogLong(this, SwornBuilder.this.confirmtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  320 */             SwornBuilder.this.confirmtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  324 */     });
/*  325 */     this.confirmtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName1(String _v_)
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     if (null == _v_)
/*  334 */       throw new NullPointerException();
/*  335 */     Logs.logIf(new LogKey(this, "name1")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  339 */         new xdb.logs.LogString(this, SwornBuilder.this.name1)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  343 */             SwornBuilder.this.name1 = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  347 */     });
/*  348 */     this.name1 = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName1Octets(Octets _v_)
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     setName1(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName2(String _v_)
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*  364 */     if (null == _v_)
/*  365 */       throw new NullPointerException();
/*  366 */     Logs.logIf(new LogKey(this, "name2")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  370 */         new xdb.logs.LogString(this, SwornBuilder.this.name2)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  374 */             SwornBuilder.this.name2 = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  378 */     });
/*  379 */     this.name2 = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName2Octets(Octets _v_)
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     setName2(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTimer(SwornWaitSession _v_)
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*  395 */     Logs.logIf(new LogKey(this, "timer")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  399 */         new xdb.logs.LogObject(this, SwornBuilder.this.timer)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  403 */             SwornBuilder.this.timer = ((SwornWaitSession)this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  407 */     });
/*  408 */     this.timer = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*  415 */     SwornBuilder _o_ = null;
/*  416 */     if ((_o1_ instanceof SwornBuilder)) { _o_ = (SwornBuilder)_o1_;
/*  417 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  418 */       return false;
/*  419 */     if (this.status != _o_.status) return false;
/*  420 */     if (this.leaderid != _o_.leaderid) return false;
/*  421 */     if (!this.roleids.equals(_o_.roleids)) return false;
/*  422 */     if (!this.agreeids.equals(_o_.agreeids)) return false;
/*  423 */     if (this.confirmtime != _o_.confirmtime) return false;
/*  424 */     if (!this.name1.equals(_o_.name1)) return false;
/*  425 */     if (!this.name2.equals(_o_.name2)) return false;
/*  426 */     if (!this.titles.equals(_o_.titles)) return false;
/*  427 */     if (((null == this.timer) && (null != _o_.timer)) || ((null != this.timer) && (null == _o_.timer)) || ((null != this.timer) && (null != _o_.timer) && (!this.timer.equals(_o_.timer)))) return false;
/*  428 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  434 */     _xdb_verify_unsafe_();
/*  435 */     int _h_ = 0;
/*  436 */     _h_ += this.status;
/*  437 */     _h_ = (int)(_h_ + this.leaderid);
/*  438 */     _h_ += this.roleids.hashCode();
/*  439 */     _h_ += this.agreeids.hashCode();
/*  440 */     _h_ = (int)(_h_ + this.confirmtime);
/*  441 */     _h_ += this.name1.hashCode();
/*  442 */     _h_ += this.name2.hashCode();
/*  443 */     _h_ += this.titles.hashCode();
/*  444 */     _h_ += (this.timer == null ? 0 : this.timer.hashCode());
/*  445 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  451 */     _xdb_verify_unsafe_();
/*  452 */     StringBuilder _sb_ = new StringBuilder();
/*  453 */     _sb_.append("(");
/*  454 */     _sb_.append(this.status);
/*  455 */     _sb_.append(",");
/*  456 */     _sb_.append(this.leaderid);
/*  457 */     _sb_.append(",");
/*  458 */     _sb_.append(this.roleids);
/*  459 */     _sb_.append(",");
/*  460 */     _sb_.append(this.agreeids);
/*  461 */     _sb_.append(",");
/*  462 */     _sb_.append(this.confirmtime);
/*  463 */     _sb_.append(",");
/*  464 */     _sb_.append("'").append(this.name1).append("'");
/*  465 */     _sb_.append(",");
/*  466 */     _sb_.append("'").append(this.name2).append("'");
/*  467 */     _sb_.append(",");
/*  468 */     _sb_.append(this.titles);
/*  469 */     _sb_.append(",");
/*  470 */     _sb_.append(this.timer);
/*  471 */     _sb_.append(")");
/*  472 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  478 */     ListenableBean lb = new ListenableBean();
/*  479 */     lb.add(new ListenableChanged().setVarName("status"));
/*  480 */     lb.add(new ListenableChanged().setVarName("leaderid"));
/*  481 */     lb.add(new ListenableChanged().setVarName("roleids"));
/*  482 */     lb.add(new ListenableChanged().setVarName("agreeids"));
/*  483 */     lb.add(new ListenableChanged().setVarName("confirmtime"));
/*  484 */     lb.add(new ListenableChanged().setVarName("name1"));
/*  485 */     lb.add(new ListenableChanged().setVarName("name2"));
/*  486 */     lb.add(new xdb.logs.ListenableMap().setVarName("titles"));
/*  487 */     lb.add(new ListenableChanged().setVarName("timer"));
/*  488 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.SwornBuilder {
/*      */     private Const() {}
/*      */     
/*      */     SwornBuilder nThis() {
/*  495 */       return SwornBuilder.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  501 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornBuilder copy()
/*      */     {
/*  507 */       return SwornBuilder.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornBuilder toData()
/*      */     {
/*  513 */       return SwornBuilder.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.SwornBuilder toBean()
/*      */     {
/*  518 */       return SwornBuilder.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornBuilder toDataIf()
/*      */     {
/*  524 */       return SwornBuilder.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.SwornBuilder toBeanIf()
/*      */     {
/*  529 */       return SwornBuilder.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatus()
/*      */     {
/*  536 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  537 */       return SwornBuilder.this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLeaderid()
/*      */     {
/*  544 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  545 */       return SwornBuilder.this.leaderid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleids()
/*      */     {
/*  552 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  553 */       return xdb.Consts.constList(SwornBuilder.this.roleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getRoleidsAsData()
/*      */     {
/*  559 */       SwornBuilder.this._xdb_verify_unsafe_();
/*      */       
/*  561 */       SwornBuilder _o_ = SwornBuilder.this;
/*  562 */       List<Long> roleids = new ArrayList();
/*  563 */       roleids.addAll(_o_.roleids);
/*  564 */       return roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAgreeids()
/*      */     {
/*  571 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  572 */       return xdb.Consts.constList(SwornBuilder.this.agreeids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getAgreeidsAsData()
/*      */     {
/*  578 */       SwornBuilder.this._xdb_verify_unsafe_();
/*      */       
/*  580 */       SwornBuilder _o_ = SwornBuilder.this;
/*  581 */       List<Long> agreeids = new ArrayList();
/*  582 */       agreeids.addAll(_o_.agreeids);
/*  583 */       return agreeids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getConfirmtime()
/*      */     {
/*  590 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  591 */       return SwornBuilder.this.confirmtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName1()
/*      */     {
/*  598 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  599 */       return SwornBuilder.this.name1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getName1Octets()
/*      */     {
/*  606 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  607 */       return SwornBuilder.this.getName1Octets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName2()
/*      */     {
/*  614 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  615 */       return SwornBuilder.this.name2;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getName2Octets()
/*      */     {
/*  622 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  623 */       return SwornBuilder.this.getName2Octets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getTitles()
/*      */     {
/*  630 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  631 */       return xdb.Consts.constMap(SwornBuilder.this.titles);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getTitlesAsData()
/*      */     {
/*  638 */       SwornBuilder.this._xdb_verify_unsafe_();
/*      */       
/*  640 */       SwornBuilder _o_ = SwornBuilder.this;
/*  641 */       Map<Long, String> titles = new HashMap();
/*  642 */       for (java.util.Map.Entry<Long, String> _e_ : _o_.titles.entrySet())
/*  643 */         titles.put(_e_.getKey(), _e_.getValue());
/*  644 */       return titles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public SwornWaitSession getTimer()
/*      */     {
/*  651 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  652 */       return SwornBuilder.this.timer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/*  659 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  660 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLeaderid(long _v_)
/*      */     {
/*  667 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  668 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setConfirmtime(long _v_)
/*      */     {
/*  675 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  676 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName1(String _v_)
/*      */     {
/*  683 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  684 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName1Octets(Octets _v_)
/*      */     {
/*  691 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  692 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName2(String _v_)
/*      */     {
/*  699 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  700 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName2Octets(Octets _v_)
/*      */     {
/*  707 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  708 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimer(SwornWaitSession _v_)
/*      */     {
/*  715 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  716 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  722 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  723 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  729 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  730 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  736 */       return SwornBuilder.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  742 */       return SwornBuilder.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  748 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  749 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  755 */       return SwornBuilder.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  761 */       return SwornBuilder.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  767 */       SwornBuilder.this._xdb_verify_unsafe_();
/*  768 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  774 */       return SwornBuilder.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  780 */       return SwornBuilder.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  786 */       return SwornBuilder.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  792 */       return SwornBuilder.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  798 */       return SwornBuilder.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  804 */       return SwornBuilder.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  810 */       return SwornBuilder.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.SwornBuilder
/*      */   {
/*      */     private int status;
/*      */     
/*      */     private long leaderid;
/*      */     
/*      */     private ArrayList<Long> roleids;
/*      */     
/*      */     private ArrayList<Long> agreeids;
/*      */     
/*      */     private long confirmtime;
/*      */     
/*      */     private String name1;
/*      */     
/*      */     private String name2;
/*      */     
/*      */     private HashMap<Long, String> titles;
/*      */     
/*      */     private SwornWaitSession timer;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  838 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  843 */       this.roleids = new ArrayList();
/*  844 */       this.agreeids = new ArrayList();
/*  845 */       this.name1 = "";
/*  846 */       this.name2 = "";
/*  847 */       this.titles = new HashMap();
/*  848 */       this.timer = null;
/*      */     }
/*      */     
/*      */     Data(xbean.SwornBuilder _o1_)
/*      */     {
/*  853 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  859 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  865 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  871 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  877 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  883 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornBuilder copy()
/*      */     {
/*  889 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornBuilder toData()
/*      */     {
/*  895 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.SwornBuilder toBean()
/*      */     {
/*  900 */       return new SwornBuilder(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornBuilder toDataIf()
/*      */     {
/*  906 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.SwornBuilder toBeanIf()
/*      */     {
/*  911 */       return new SwornBuilder(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  917 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  921 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  925 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  929 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  933 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  937 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  941 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatus()
/*      */     {
/*  948 */       return this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLeaderid()
/*      */     {
/*  955 */       return this.leaderid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleids()
/*      */     {
/*  962 */       return this.roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleidsAsData()
/*      */     {
/*  969 */       return this.roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAgreeids()
/*      */     {
/*  976 */       return this.agreeids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAgreeidsAsData()
/*      */     {
/*  983 */       return this.agreeids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getConfirmtime()
/*      */     {
/*  990 */       return this.confirmtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName1()
/*      */     {
/*  997 */       return this.name1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getName1Octets()
/*      */     {
/* 1004 */       return Octets.wrap(getName1(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName2()
/*      */     {
/* 1011 */       return this.name2;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getName2Octets()
/*      */     {
/* 1018 */       return Octets.wrap(getName2(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getTitles()
/*      */     {
/* 1025 */       return this.titles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getTitlesAsData()
/*      */     {
/* 1032 */       return this.titles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public SwornWaitSession getTimer()
/*      */     {
/* 1039 */       return this.timer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/* 1046 */       this.status = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLeaderid(long _v_)
/*      */     {
/* 1053 */       this.leaderid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setConfirmtime(long _v_)
/*      */     {
/* 1060 */       this.confirmtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName1(String _v_)
/*      */     {
/* 1067 */       if (null == _v_)
/* 1068 */         throw new NullPointerException();
/* 1069 */       this.name1 = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName1Octets(Octets _v_)
/*      */     {
/* 1076 */       setName1(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName2(String _v_)
/*      */     {
/* 1083 */       if (null == _v_)
/* 1084 */         throw new NullPointerException();
/* 1085 */       this.name2 = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName2Octets(Octets _v_)
/*      */     {
/* 1092 */       setName2(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimer(SwornWaitSession _v_)
/*      */     {
/* 1099 */       this.timer = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1105 */       if (!(_o1_ instanceof Data)) return false;
/* 1106 */       Data _o_ = (Data)_o1_;
/* 1107 */       if (this.status != _o_.status) return false;
/* 1108 */       if (this.leaderid != _o_.leaderid) return false;
/* 1109 */       if (!this.roleids.equals(_o_.roleids)) return false;
/* 1110 */       if (!this.agreeids.equals(_o_.agreeids)) return false;
/* 1111 */       if (this.confirmtime != _o_.confirmtime) return false;
/* 1112 */       if (!this.name1.equals(_o_.name1)) return false;
/* 1113 */       if (!this.name2.equals(_o_.name2)) return false;
/* 1114 */       if (!this.titles.equals(_o_.titles)) return false;
/* 1115 */       if (((null == this.timer) && (null != _o_.timer)) || ((null != this.timer) && (null == _o_.timer)) || ((null != this.timer) && (null != _o_.timer) && (!this.timer.equals(_o_.timer)))) return false;
/* 1116 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1122 */       int _h_ = 0;
/* 1123 */       _h_ += this.status;
/* 1124 */       _h_ = (int)(_h_ + this.leaderid);
/* 1125 */       _h_ += this.roleids.hashCode();
/* 1126 */       _h_ += this.agreeids.hashCode();
/* 1127 */       _h_ = (int)(_h_ + this.confirmtime);
/* 1128 */       _h_ += this.name1.hashCode();
/* 1129 */       _h_ += this.name2.hashCode();
/* 1130 */       _h_ += this.titles.hashCode();
/* 1131 */       _h_ += (this.timer == null ? 0 : this.timer.hashCode());
/* 1132 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1138 */       StringBuilder _sb_ = new StringBuilder();
/* 1139 */       _sb_.append("(");
/* 1140 */       _sb_.append(this.status);
/* 1141 */       _sb_.append(",");
/* 1142 */       _sb_.append(this.leaderid);
/* 1143 */       _sb_.append(",");
/* 1144 */       _sb_.append(this.roleids);
/* 1145 */       _sb_.append(",");
/* 1146 */       _sb_.append(this.agreeids);
/* 1147 */       _sb_.append(",");
/* 1148 */       _sb_.append(this.confirmtime);
/* 1149 */       _sb_.append(",");
/* 1150 */       _sb_.append("'").append(this.name1).append("'");
/* 1151 */       _sb_.append(",");
/* 1152 */       _sb_.append("'").append(this.name2).append("'");
/* 1153 */       _sb_.append(",");
/* 1154 */       _sb_.append(this.titles);
/* 1155 */       _sb_.append(",");
/* 1156 */       _sb_.append(this.timer);
/* 1157 */       _sb_.append(")");
/* 1158 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SwornBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */