/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class WorldQuestionBean extends XBean implements xbean.WorldQuestionBean
/*      */ {
/*      */   private ArrayList<xbean.WAwardBean> roleawarddata;
/*      */   private boolean going;
/*      */   private long lasttime;
/*      */   private long nexttime;
/*      */   private int questionid;
/*      */   private ArrayList<Integer> oldquestionids;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.roleawarddata.clear();
/*   29 */     this.going = false;
/*   30 */     this.lasttime = 0L;
/*   31 */     this.nexttime = 0L;
/*   32 */     this.questionid = 0;
/*   33 */     this.oldquestionids.clear();
/*      */   }
/*      */   
/*      */   WorldQuestionBean(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.roleawarddata = new ArrayList();
/*   40 */     this.oldquestionids = new ArrayList();
/*      */   }
/*      */   
/*      */   public WorldQuestionBean()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public WorldQuestionBean(WorldQuestionBean _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   WorldQuestionBean(xbean.WorldQuestionBean _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof WorldQuestionBean)) { assign((WorldQuestionBean)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(WorldQuestionBean _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.roleawarddata = new ArrayList();
/*   66 */     for (xbean.WAwardBean _v_ : _o_.roleawarddata)
/*   67 */       this.roleawarddata.add(new WAwardBean(_v_, this, "roleawarddata"));
/*   68 */     this.going = _o_.going;
/*   69 */     this.lasttime = _o_.lasttime;
/*   70 */     this.nexttime = _o_.nexttime;
/*   71 */     this.questionid = _o_.questionid;
/*   72 */     this.oldquestionids = new ArrayList();
/*   73 */     this.oldquestionids.addAll(_o_.oldquestionids);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   78 */     this.roleawarddata = new ArrayList();
/*   79 */     for (xbean.WAwardBean _v_ : _o_.roleawarddata)
/*   80 */       this.roleawarddata.add(new WAwardBean(_v_, this, "roleawarddata"));
/*   81 */     this.going = _o_.going;
/*   82 */     this.lasttime = _o_.lasttime;
/*   83 */     this.nexttime = _o_.nexttime;
/*   84 */     this.questionid = _o_.questionid;
/*   85 */     this.oldquestionids = new ArrayList();
/*   86 */     this.oldquestionids.addAll(_o_.oldquestionids);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   92 */     _xdb_verify_unsafe_();
/*   93 */     _os_.compact_uint32(this.roleawarddata.size());
/*   94 */     for (xbean.WAwardBean _v_ : this.roleawarddata)
/*      */     {
/*   96 */       _v_.marshal(_os_);
/*      */     }
/*   98 */     _os_.marshal(this.going);
/*   99 */     _os_.marshal(this.lasttime);
/*  100 */     _os_.marshal(this.nexttime);
/*  101 */     _os_.marshal(this.questionid);
/*  102 */     _os_.compact_uint32(this.oldquestionids.size());
/*  103 */     for (Integer _v_ : this.oldquestionids)
/*      */     {
/*  105 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  107 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  113 */     _xdb_verify_unsafe_();
/*  114 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  116 */       xbean.WAwardBean _v_ = new WAwardBean(0, this, "roleawarddata");
/*  117 */       _v_.unmarshal(_os_);
/*  118 */       this.roleawarddata.add(_v_);
/*      */     }
/*  120 */     this.going = _os_.unmarshal_boolean();
/*  121 */     this.lasttime = _os_.unmarshal_long();
/*  122 */     this.nexttime = _os_.unmarshal_long();
/*  123 */     this.questionid = _os_.unmarshal_int();
/*  124 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  126 */       int _v_ = 0;
/*  127 */       _v_ = _os_.unmarshal_int();
/*  128 */       this.oldquestionids.add(Integer.valueOf(_v_));
/*      */     }
/*  130 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  136 */     _xdb_verify_unsafe_();
/*  137 */     int _size_ = 0;
/*  138 */     for (xbean.WAwardBean _v_ : this.roleawarddata)
/*      */     {
/*  140 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*      */     }
/*  142 */     _size_ += CodedOutputStream.computeBoolSize(2, this.going);
/*  143 */     _size_ += CodedOutputStream.computeInt64Size(3, this.lasttime);
/*  144 */     _size_ += CodedOutputStream.computeInt64Size(4, this.nexttime);
/*  145 */     _size_ += CodedOutputStream.computeInt32Size(5, this.questionid);
/*  146 */     for (Integer _v_ : this.oldquestionids)
/*      */     {
/*  148 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  150 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  156 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  159 */       for (xbean.WAwardBean _v_ : this.roleawarddata)
/*      */       {
/*  161 */         _output_.writeMessage(1, _v_);
/*      */       }
/*  163 */       _output_.writeBool(2, this.going);
/*  164 */       _output_.writeInt64(3, this.lasttime);
/*  165 */       _output_.writeInt64(4, this.nexttime);
/*  166 */       _output_.writeInt32(5, this.questionid);
/*  167 */       for (Integer _v_ : this.oldquestionids)
/*      */       {
/*  169 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  174 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  176 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  182 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  185 */       boolean done = false;
/*  186 */       while (!done)
/*      */       {
/*  188 */         int tag = _input_.readTag();
/*  189 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  193 */           done = true;
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  198 */           xbean.WAwardBean _v_ = new WAwardBean(0, this, "roleawarddata");
/*  199 */           _input_.readMessage(_v_);
/*  200 */           this.roleawarddata.add(_v_);
/*  201 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  205 */           this.going = _input_.readBool();
/*  206 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  210 */           this.lasttime = _input_.readInt64();
/*  211 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  215 */           this.nexttime = _input_.readInt64();
/*  216 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  220 */           this.questionid = _input_.readInt32();
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  225 */           int _v_ = 0;
/*  226 */           _v_ = _input_.readInt32();
/*  227 */           this.oldquestionids.add(Integer.valueOf(_v_));
/*  228 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  232 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  234 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  243 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  247 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  249 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WorldQuestionBean copy()
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*  256 */     return new WorldQuestionBean(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WorldQuestionBean toData()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.WorldQuestionBean toBean()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return new WorldQuestionBean(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WorldQuestionBean toDataIf()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.WorldQuestionBean toBeanIf()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.WAwardBean> getRoleawarddata()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return Logs.logList(new LogKey(this, "roleawarddata"), this.roleawarddata);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.WAwardBean> getRoleawarddataAsData()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*      */     
/*  305 */     WorldQuestionBean _o_ = this;
/*  306 */     List<xbean.WAwardBean> roleawarddata = new ArrayList();
/*  307 */     for (xbean.WAwardBean _v_ : _o_.roleawarddata)
/*  308 */       roleawarddata.add(new WAwardBean.Data(_v_));
/*  309 */     return roleawarddata;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getGoing()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return this.going;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLasttime()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     return this.lasttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getNexttime()
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     return this.nexttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getQuestionid()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     return this.questionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getOldquestionids()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return Logs.logList(new LogKey(this, "oldquestionids"), this.oldquestionids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getOldquestionidsAsData()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*      */     
/*  357 */     WorldQuestionBean _o_ = this;
/*  358 */     List<Integer> oldquestionids = new ArrayList();
/*  359 */     oldquestionids.addAll(_o_.oldquestionids);
/*  360 */     return oldquestionids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGoing(boolean _v_)
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     Logs.logIf(new LogKey(this, "going")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  372 */         new xdb.logs.LogObject(this, Boolean.valueOf(WorldQuestionBean.this.going))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  376 */             WorldQuestionBean.this.going = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  380 */     });
/*  381 */     this.going = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLasttime(long _v_)
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     Logs.logIf(new LogKey(this, "lasttime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  393 */         new xdb.logs.LogLong(this, WorldQuestionBean.this.lasttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  397 */             WorldQuestionBean.this.lasttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  401 */     });
/*  402 */     this.lasttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNexttime(long _v_)
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     Logs.logIf(new LogKey(this, "nexttime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  414 */         new xdb.logs.LogLong(this, WorldQuestionBean.this.nexttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  418 */             WorldQuestionBean.this.nexttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  422 */     });
/*  423 */     this.nexttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setQuestionid(int _v_)
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     Logs.logIf(new LogKey(this, "questionid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  435 */         new xdb.logs.LogInt(this, WorldQuestionBean.this.questionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  439 */             WorldQuestionBean.this.questionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  443 */     });
/*  444 */     this.questionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     WorldQuestionBean _o_ = null;
/*  452 */     if ((_o1_ instanceof WorldQuestionBean)) { _o_ = (WorldQuestionBean)_o1_;
/*  453 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  454 */       return false;
/*  455 */     if (!this.roleawarddata.equals(_o_.roleawarddata)) return false;
/*  456 */     if (this.going != _o_.going) return false;
/*  457 */     if (this.lasttime != _o_.lasttime) return false;
/*  458 */     if (this.nexttime != _o_.nexttime) return false;
/*  459 */     if (this.questionid != _o_.questionid) return false;
/*  460 */     if (!this.oldquestionids.equals(_o_.oldquestionids)) return false;
/*  461 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  467 */     _xdb_verify_unsafe_();
/*  468 */     int _h_ = 0;
/*  469 */     _h_ += this.roleawarddata.hashCode();
/*  470 */     _h_ += (this.going ? 1231 : 1237);
/*  471 */     _h_ = (int)(_h_ + this.lasttime);
/*  472 */     _h_ = (int)(_h_ + this.nexttime);
/*  473 */     _h_ += this.questionid;
/*  474 */     _h_ += this.oldquestionids.hashCode();
/*  475 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  481 */     _xdb_verify_unsafe_();
/*  482 */     StringBuilder _sb_ = new StringBuilder();
/*  483 */     _sb_.append("(");
/*  484 */     _sb_.append(this.roleawarddata);
/*  485 */     _sb_.append(",");
/*  486 */     _sb_.append(this.going);
/*  487 */     _sb_.append(",");
/*  488 */     _sb_.append(this.lasttime);
/*  489 */     _sb_.append(",");
/*  490 */     _sb_.append(this.nexttime);
/*  491 */     _sb_.append(",");
/*  492 */     _sb_.append(this.questionid);
/*  493 */     _sb_.append(",");
/*  494 */     _sb_.append(this.oldquestionids);
/*  495 */     _sb_.append(")");
/*  496 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  502 */     ListenableBean lb = new ListenableBean();
/*  503 */     lb.add(new ListenableChanged().setVarName("roleawarddata"));
/*  504 */     lb.add(new ListenableChanged().setVarName("going"));
/*  505 */     lb.add(new ListenableChanged().setVarName("lasttime"));
/*  506 */     lb.add(new ListenableChanged().setVarName("nexttime"));
/*  507 */     lb.add(new ListenableChanged().setVarName("questionid"));
/*  508 */     lb.add(new ListenableChanged().setVarName("oldquestionids"));
/*  509 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.WorldQuestionBean {
/*      */     private Const() {}
/*      */     
/*      */     WorldQuestionBean nThis() {
/*  516 */       return WorldQuestionBean.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  522 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldQuestionBean copy()
/*      */     {
/*  528 */       return WorldQuestionBean.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldQuestionBean toData()
/*      */     {
/*  534 */       return WorldQuestionBean.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.WorldQuestionBean toBean()
/*      */     {
/*  539 */       return WorldQuestionBean.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldQuestionBean toDataIf()
/*      */     {
/*  545 */       return WorldQuestionBean.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.WorldQuestionBean toBeanIf()
/*      */     {
/*  550 */       return WorldQuestionBean.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.WAwardBean> getRoleawarddata()
/*      */     {
/*  557 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  558 */       return xdb.Consts.constList(WorldQuestionBean.this.roleawarddata);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.WAwardBean> getRoleawarddataAsData()
/*      */     {
/*  564 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*      */       
/*  566 */       WorldQuestionBean _o_ = WorldQuestionBean.this;
/*  567 */       List<xbean.WAwardBean> roleawarddata = new ArrayList();
/*  568 */       for (xbean.WAwardBean _v_ : _o_.roleawarddata)
/*  569 */         roleawarddata.add(new WAwardBean.Data(_v_));
/*  570 */       return roleawarddata;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getGoing()
/*      */     {
/*  577 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  578 */       return WorldQuestionBean.this.going;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLasttime()
/*      */     {
/*  585 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  586 */       return WorldQuestionBean.this.lasttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNexttime()
/*      */     {
/*  593 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  594 */       return WorldQuestionBean.this.nexttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getQuestionid()
/*      */     {
/*  601 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  602 */       return WorldQuestionBean.this.questionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getOldquestionids()
/*      */     {
/*  609 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  610 */       return xdb.Consts.constList(WorldQuestionBean.this.oldquestionids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getOldquestionidsAsData()
/*      */     {
/*  616 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*      */       
/*  618 */       WorldQuestionBean _o_ = WorldQuestionBean.this;
/*  619 */       List<Integer> oldquestionids = new ArrayList();
/*  620 */       oldquestionids.addAll(_o_.oldquestionids);
/*  621 */       return oldquestionids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGoing(boolean _v_)
/*      */     {
/*  628 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  629 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLasttime(long _v_)
/*      */     {
/*  636 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  637 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNexttime(long _v_)
/*      */     {
/*  644 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  645 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setQuestionid(int _v_)
/*      */     {
/*  652 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  653 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  659 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  660 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  666 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  667 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  673 */       return WorldQuestionBean.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  679 */       return WorldQuestionBean.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  685 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  686 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  692 */       return WorldQuestionBean.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  698 */       return WorldQuestionBean.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  704 */       WorldQuestionBean.this._xdb_verify_unsafe_();
/*  705 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  711 */       return WorldQuestionBean.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  717 */       return WorldQuestionBean.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  723 */       return WorldQuestionBean.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  729 */       return WorldQuestionBean.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  735 */       return WorldQuestionBean.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  741 */       return WorldQuestionBean.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  747 */       return WorldQuestionBean.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.WorldQuestionBean
/*      */   {
/*      */     private ArrayList<xbean.WAwardBean> roleawarddata;
/*      */     
/*      */     private boolean going;
/*      */     
/*      */     private long lasttime;
/*      */     
/*      */     private long nexttime;
/*      */     
/*      */     private int questionid;
/*      */     
/*      */     private ArrayList<Integer> oldquestionids;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  769 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  774 */       this.roleawarddata = new ArrayList();
/*  775 */       this.oldquestionids = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.WorldQuestionBean _o1_)
/*      */     {
/*  780 */       if ((_o1_ instanceof WorldQuestionBean)) { assign((WorldQuestionBean)_o1_);
/*  781 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  782 */       } else if ((_o1_ instanceof WorldQuestionBean.Const)) assign(((WorldQuestionBean.Const)_o1_).nThis()); else {
/*  783 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(WorldQuestionBean _o_) {
/*  788 */       this.roleawarddata = new ArrayList();
/*  789 */       for (xbean.WAwardBean _v_ : _o_.roleawarddata)
/*  790 */         this.roleawarddata.add(new WAwardBean.Data(_v_));
/*  791 */       this.going = _o_.going;
/*  792 */       this.lasttime = _o_.lasttime;
/*  793 */       this.nexttime = _o_.nexttime;
/*  794 */       this.questionid = _o_.questionid;
/*  795 */       this.oldquestionids = new ArrayList();
/*  796 */       this.oldquestionids.addAll(_o_.oldquestionids);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  801 */       this.roleawarddata = new ArrayList();
/*  802 */       for (xbean.WAwardBean _v_ : _o_.roleawarddata)
/*  803 */         this.roleawarddata.add(new WAwardBean.Data(_v_));
/*  804 */       this.going = _o_.going;
/*  805 */       this.lasttime = _o_.lasttime;
/*  806 */       this.nexttime = _o_.nexttime;
/*  807 */       this.questionid = _o_.questionid;
/*  808 */       this.oldquestionids = new ArrayList();
/*  809 */       this.oldquestionids.addAll(_o_.oldquestionids);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  815 */       _os_.compact_uint32(this.roleawarddata.size());
/*  816 */       for (xbean.WAwardBean _v_ : this.roleawarddata)
/*      */       {
/*  818 */         _v_.marshal(_os_);
/*      */       }
/*  820 */       _os_.marshal(this.going);
/*  821 */       _os_.marshal(this.lasttime);
/*  822 */       _os_.marshal(this.nexttime);
/*  823 */       _os_.marshal(this.questionid);
/*  824 */       _os_.compact_uint32(this.oldquestionids.size());
/*  825 */       for (Integer _v_ : this.oldquestionids)
/*      */       {
/*  827 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  829 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  835 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  837 */         xbean.WAwardBean _v_ = xbean.Pod.newWAwardBeanData();
/*  838 */         _v_.unmarshal(_os_);
/*  839 */         this.roleawarddata.add(_v_);
/*      */       }
/*  841 */       this.going = _os_.unmarshal_boolean();
/*  842 */       this.lasttime = _os_.unmarshal_long();
/*  843 */       this.nexttime = _os_.unmarshal_long();
/*  844 */       this.questionid = _os_.unmarshal_int();
/*  845 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  847 */         int _v_ = 0;
/*  848 */         _v_ = _os_.unmarshal_int();
/*  849 */         this.oldquestionids.add(Integer.valueOf(_v_));
/*      */       }
/*  851 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  857 */       int _size_ = 0;
/*  858 */       for (xbean.WAwardBean _v_ : this.roleawarddata)
/*      */       {
/*  860 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*      */       }
/*  862 */       _size_ += CodedOutputStream.computeBoolSize(2, this.going);
/*  863 */       _size_ += CodedOutputStream.computeInt64Size(3, this.lasttime);
/*  864 */       _size_ += CodedOutputStream.computeInt64Size(4, this.nexttime);
/*  865 */       _size_ += CodedOutputStream.computeInt32Size(5, this.questionid);
/*  866 */       for (Integer _v_ : this.oldquestionids)
/*      */       {
/*  868 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/*  870 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  878 */         for (xbean.WAwardBean _v_ : this.roleawarddata)
/*      */         {
/*  880 */           _output_.writeMessage(1, _v_);
/*      */         }
/*  882 */         _output_.writeBool(2, this.going);
/*  883 */         _output_.writeInt64(3, this.lasttime);
/*  884 */         _output_.writeInt64(4, this.nexttime);
/*  885 */         _output_.writeInt32(5, this.questionid);
/*  886 */         for (Integer _v_ : this.oldquestionids)
/*      */         {
/*  888 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  893 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  895 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  903 */         boolean done = false;
/*  904 */         while (!done)
/*      */         {
/*  906 */           int tag = _input_.readTag();
/*  907 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  911 */             done = true;
/*  912 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/*  916 */             xbean.WAwardBean _v_ = xbean.Pod.newWAwardBeanData();
/*  917 */             _input_.readMessage(_v_);
/*  918 */             this.roleawarddata.add(_v_);
/*  919 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  923 */             this.going = _input_.readBool();
/*  924 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  928 */             this.lasttime = _input_.readInt64();
/*  929 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  933 */             this.nexttime = _input_.readInt64();
/*  934 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  938 */             this.questionid = _input_.readInt32();
/*  939 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  943 */             int _v_ = 0;
/*  944 */             _v_ = _input_.readInt32();
/*  945 */             this.oldquestionids.add(Integer.valueOf(_v_));
/*  946 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  950 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  952 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  961 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  965 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  967 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldQuestionBean copy()
/*      */     {
/*  973 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldQuestionBean toData()
/*      */     {
/*  979 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.WorldQuestionBean toBean()
/*      */     {
/*  984 */       return new WorldQuestionBean(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldQuestionBean toDataIf()
/*      */     {
/*  990 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.WorldQuestionBean toBeanIf()
/*      */     {
/*  995 */       return new WorldQuestionBean(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1001 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1005 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1009 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1013 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1017 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1021 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1025 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.WAwardBean> getRoleawarddata()
/*      */     {
/* 1032 */       return this.roleawarddata;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.WAwardBean> getRoleawarddataAsData()
/*      */     {
/* 1039 */       return this.roleawarddata;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getGoing()
/*      */     {
/* 1046 */       return this.going;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLasttime()
/*      */     {
/* 1053 */       return this.lasttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNexttime()
/*      */     {
/* 1060 */       return this.nexttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getQuestionid()
/*      */     {
/* 1067 */       return this.questionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getOldquestionids()
/*      */     {
/* 1074 */       return this.oldquestionids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getOldquestionidsAsData()
/*      */     {
/* 1081 */       return this.oldquestionids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGoing(boolean _v_)
/*      */     {
/* 1088 */       this.going = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLasttime(long _v_)
/*      */     {
/* 1095 */       this.lasttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNexttime(long _v_)
/*      */     {
/* 1102 */       this.nexttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setQuestionid(int _v_)
/*      */     {
/* 1109 */       this.questionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1115 */       if (!(_o1_ instanceof Data)) return false;
/* 1116 */       Data _o_ = (Data)_o1_;
/* 1117 */       if (!this.roleawarddata.equals(_o_.roleawarddata)) return false;
/* 1118 */       if (this.going != _o_.going) return false;
/* 1119 */       if (this.lasttime != _o_.lasttime) return false;
/* 1120 */       if (this.nexttime != _o_.nexttime) return false;
/* 1121 */       if (this.questionid != _o_.questionid) return false;
/* 1122 */       if (!this.oldquestionids.equals(_o_.oldquestionids)) return false;
/* 1123 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1129 */       int _h_ = 0;
/* 1130 */       _h_ += this.roleawarddata.hashCode();
/* 1131 */       _h_ += (this.going ? 1231 : 1237);
/* 1132 */       _h_ = (int)(_h_ + this.lasttime);
/* 1133 */       _h_ = (int)(_h_ + this.nexttime);
/* 1134 */       _h_ += this.questionid;
/* 1135 */       _h_ += this.oldquestionids.hashCode();
/* 1136 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1142 */       StringBuilder _sb_ = new StringBuilder();
/* 1143 */       _sb_.append("(");
/* 1144 */       _sb_.append(this.roleawarddata);
/* 1145 */       _sb_.append(",");
/* 1146 */       _sb_.append(this.going);
/* 1147 */       _sb_.append(",");
/* 1148 */       _sb_.append(this.lasttime);
/* 1149 */       _sb_.append(",");
/* 1150 */       _sb_.append(this.nexttime);
/* 1151 */       _sb_.append(",");
/* 1152 */       _sb_.append(this.questionid);
/* 1153 */       _sb_.append(",");
/* 1154 */       _sb_.append(this.oldquestionids);
/* 1155 */       _sb_.append(")");
/* 1156 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\WorldQuestionBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */