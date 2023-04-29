/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashSet;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class InteractivetaskInfo extends XBean implements xbean.InteractivetaskInfo
/*      */ {
/*      */   private long worldid;
/*      */   private LinkedList<Integer> finished_graphids;
/*      */   private int current_graphid;
/*      */   private SetX<Long> roleids;
/*      */   private long commander_roleid;
/*      */   private long sessionid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.worldid = 0L;
/*   29 */     this.finished_graphids.clear();
/*   30 */     this.current_graphid = 0;
/*   31 */     this.roleids.clear();
/*   32 */     this.commander_roleid = 0L;
/*   33 */     this.sessionid = 0L;
/*      */   }
/*      */   
/*      */   InteractivetaskInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.finished_graphids = new LinkedList();
/*   40 */     this.roleids = new SetX();
/*      */   }
/*      */   
/*      */   public InteractivetaskInfo()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public InteractivetaskInfo(InteractivetaskInfo _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   InteractivetaskInfo(xbean.InteractivetaskInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof InteractivetaskInfo)) { assign((InteractivetaskInfo)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(InteractivetaskInfo _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.worldid = _o_.worldid;
/*   66 */     this.finished_graphids = new LinkedList();
/*   67 */     this.finished_graphids.addAll(_o_.finished_graphids);
/*   68 */     this.current_graphid = _o_.current_graphid;
/*   69 */     this.roleids = new SetX();
/*   70 */     this.roleids.addAll(_o_.roleids);
/*   71 */     this.commander_roleid = _o_.commander_roleid;
/*   72 */     this.sessionid = _o_.sessionid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   77 */     this.worldid = _o_.worldid;
/*   78 */     this.finished_graphids = new LinkedList();
/*   79 */     this.finished_graphids.addAll(_o_.finished_graphids);
/*   80 */     this.current_graphid = _o_.current_graphid;
/*   81 */     this.roleids = new SetX();
/*   82 */     this.roleids.addAll(_o_.roleids);
/*   83 */     this.commander_roleid = _o_.commander_roleid;
/*   84 */     this.sessionid = _o_.sessionid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     _os_.marshal(this.worldid);
/*   92 */     _os_.compact_uint32(this.finished_graphids.size());
/*   93 */     for (Integer _v_ : this.finished_graphids)
/*      */     {
/*   95 */       _os_.marshal(_v_.intValue());
/*      */     }
/*   97 */     _os_.marshal(this.current_graphid);
/*   98 */     _os_.compact_uint32(this.roleids.size());
/*   99 */     for (Long _v_ : this.roleids)
/*      */     {
/*  101 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  103 */     _os_.marshal(this.commander_roleid);
/*  104 */     _os_.marshal(this.sessionid);
/*  105 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  111 */     _xdb_verify_unsafe_();
/*  112 */     this.worldid = _os_.unmarshal_long();
/*  113 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  115 */       int _v_ = 0;
/*  116 */       _v_ = _os_.unmarshal_int();
/*  117 */       this.finished_graphids.add(Integer.valueOf(_v_));
/*      */     }
/*  119 */     this.current_graphid = _os_.unmarshal_int();
/*  120 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  122 */       long _v_ = 0L;
/*  123 */       _v_ = _os_.unmarshal_long();
/*  124 */       this.roleids.add(Long.valueOf(_v_));
/*      */     }
/*  126 */     this.commander_roleid = _os_.unmarshal_long();
/*  127 */     this.sessionid = _os_.unmarshal_long();
/*  128 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  134 */     _xdb_verify_unsafe_();
/*  135 */     int _size_ = 0;
/*  136 */     _size_ += CodedOutputStream.computeInt64Size(1, this.worldid);
/*  137 */     for (Integer _v_ : this.finished_graphids)
/*      */     {
/*  139 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */     }
/*  141 */     _size_ += CodedOutputStream.computeInt32Size(3, this.current_graphid);
/*  142 */     for (Long _v_ : this.roleids)
/*      */     {
/*  144 */       _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */     }
/*  146 */     _size_ += CodedOutputStream.computeInt64Size(5, this.commander_roleid);
/*  147 */     _size_ += CodedOutputStream.computeInt64Size(6, this.sessionid);
/*  148 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  154 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  157 */       _output_.writeInt64(1, this.worldid);
/*  158 */       for (Integer _v_ : this.finished_graphids)
/*      */       {
/*  160 */         _output_.writeInt32(2, _v_.intValue());
/*      */       }
/*  162 */       _output_.writeInt32(3, this.current_graphid);
/*  163 */       for (Long _v_ : this.roleids)
/*      */       {
/*  165 */         _output_.writeInt64(4, _v_.longValue());
/*      */       }
/*  167 */       _output_.writeInt64(5, this.commander_roleid);
/*  168 */       _output_.writeInt64(6, this.sessionid);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  172 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  174 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  180 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  183 */       boolean done = false;
/*  184 */       while (!done)
/*      */       {
/*  186 */         int tag = _input_.readTag();
/*  187 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  191 */           done = true;
/*  192 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  196 */           this.worldid = _input_.readInt64();
/*  197 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  201 */           int _v_ = 0;
/*  202 */           _v_ = _input_.readInt32();
/*  203 */           this.finished_graphids.add(Integer.valueOf(_v_));
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  208 */           this.current_graphid = _input_.readInt32();
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  213 */           long _v_ = 0L;
/*  214 */           _v_ = _input_.readInt64();
/*  215 */           this.roleids.add(Long.valueOf(_v_));
/*  216 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  220 */           this.commander_roleid = _input_.readInt64();
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  225 */           this.sessionid = _input_.readInt64();
/*  226 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  230 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  232 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  241 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  245 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  247 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.InteractivetaskInfo copy()
/*      */   {
/*  253 */     _xdb_verify_unsafe_();
/*  254 */     return new InteractivetaskInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.InteractivetaskInfo toData()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.InteractivetaskInfo toBean()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return new InteractivetaskInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.InteractivetaskInfo toDataIf()
/*      */   {
/*  273 */     _xdb_verify_unsafe_();
/*  274 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.InteractivetaskInfo toBeanIf()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWorldid()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return this.worldid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getFinished_graphids()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return xdb.Logs.logList(new LogKey(this, "finished_graphids"), this.finished_graphids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getFinished_graphidsAsData()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*      */     
/*  311 */     InteractivetaskInfo _o_ = this;
/*  312 */     List<Integer> finished_graphids = new LinkedList();
/*  313 */     finished_graphids.addAll(_o_.finished_graphids);
/*  314 */     return finished_graphids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_graphid()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return this.current_graphid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getRoleids()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return xdb.Logs.logSet(new LogKey(this, "roleids"), this.roleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getRoleidsAsData()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*      */     
/*  338 */     InteractivetaskInfo _o_ = this;
/*  339 */     Set<Long> roleids = new SetX();
/*  340 */     roleids.addAll(_o_.roleids);
/*  341 */     return roleids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCommander_roleid()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return this.commander_roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSessionid()
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     return this.sessionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWorldid(long _v_)
/*      */   {
/*  364 */     _xdb_verify_unsafe_();
/*  365 */     xdb.Logs.logIf(new LogKey(this, "worldid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  369 */         new xdb.logs.LogLong(this, InteractivetaskInfo.this.worldid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  373 */             InteractivetaskInfo.this.worldid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  377 */     });
/*  378 */     this.worldid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_graphid(int _v_)
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     xdb.Logs.logIf(new LogKey(this, "current_graphid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  390 */         new xdb.logs.LogInt(this, InteractivetaskInfo.this.current_graphid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  394 */             InteractivetaskInfo.this.current_graphid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  398 */     });
/*  399 */     this.current_graphid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCommander_roleid(long _v_)
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     xdb.Logs.logIf(new LogKey(this, "commander_roleid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  411 */         new xdb.logs.LogLong(this, InteractivetaskInfo.this.commander_roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  415 */             InteractivetaskInfo.this.commander_roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  419 */     });
/*  420 */     this.commander_roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSessionid(long _v_)
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     xdb.Logs.logIf(new LogKey(this, "sessionid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  432 */         new xdb.logs.LogLong(this, InteractivetaskInfo.this.sessionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  436 */             InteractivetaskInfo.this.sessionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  440 */     });
/*  441 */     this.sessionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  447 */     _xdb_verify_unsafe_();
/*  448 */     InteractivetaskInfo _o_ = null;
/*  449 */     if ((_o1_ instanceof InteractivetaskInfo)) { _o_ = (InteractivetaskInfo)_o1_;
/*  450 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  451 */       return false;
/*  452 */     if (this.worldid != _o_.worldid) return false;
/*  453 */     if (!this.finished_graphids.equals(_o_.finished_graphids)) return false;
/*  454 */     if (this.current_graphid != _o_.current_graphid) return false;
/*  455 */     if (!this.roleids.equals(_o_.roleids)) return false;
/*  456 */     if (this.commander_roleid != _o_.commander_roleid) return false;
/*  457 */     if (this.sessionid != _o_.sessionid) return false;
/*  458 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*  465 */     int _h_ = 0;
/*  466 */     _h_ = (int)(_h_ + this.worldid);
/*  467 */     _h_ += this.finished_graphids.hashCode();
/*  468 */     _h_ += this.current_graphid;
/*  469 */     _h_ += this.roleids.hashCode();
/*  470 */     _h_ = (int)(_h_ + this.commander_roleid);
/*  471 */     _h_ = (int)(_h_ + this.sessionid);
/*  472 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  478 */     _xdb_verify_unsafe_();
/*  479 */     StringBuilder _sb_ = new StringBuilder();
/*  480 */     _sb_.append("(");
/*  481 */     _sb_.append(this.worldid);
/*  482 */     _sb_.append(",");
/*  483 */     _sb_.append(this.finished_graphids);
/*  484 */     _sb_.append(",");
/*  485 */     _sb_.append(this.current_graphid);
/*  486 */     _sb_.append(",");
/*  487 */     _sb_.append(this.roleids);
/*  488 */     _sb_.append(",");
/*  489 */     _sb_.append(this.commander_roleid);
/*  490 */     _sb_.append(",");
/*  491 */     _sb_.append(this.sessionid);
/*  492 */     _sb_.append(")");
/*  493 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  499 */     ListenableBean lb = new ListenableBean();
/*  500 */     lb.add(new ListenableChanged().setVarName("worldid"));
/*  501 */     lb.add(new ListenableChanged().setVarName("finished_graphids"));
/*  502 */     lb.add(new ListenableChanged().setVarName("current_graphid"));
/*  503 */     lb.add(new xdb.logs.ListenableSet().setVarName("roleids"));
/*  504 */     lb.add(new ListenableChanged().setVarName("commander_roleid"));
/*  505 */     lb.add(new ListenableChanged().setVarName("sessionid"));
/*  506 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.InteractivetaskInfo {
/*      */     private Const() {}
/*      */     
/*      */     InteractivetaskInfo nThis() {
/*  513 */       return InteractivetaskInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  519 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.InteractivetaskInfo copy()
/*      */     {
/*  525 */       return InteractivetaskInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.InteractivetaskInfo toData()
/*      */     {
/*  531 */       return InteractivetaskInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.InteractivetaskInfo toBean()
/*      */     {
/*  536 */       return InteractivetaskInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.InteractivetaskInfo toDataIf()
/*      */     {
/*  542 */       return InteractivetaskInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.InteractivetaskInfo toBeanIf()
/*      */     {
/*  547 */       return InteractivetaskInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorldid()
/*      */     {
/*  554 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  555 */       return InteractivetaskInfo.this.worldid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getFinished_graphids()
/*      */     {
/*  562 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  563 */       return xdb.Consts.constList(InteractivetaskInfo.this.finished_graphids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getFinished_graphidsAsData()
/*      */     {
/*  569 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*      */       
/*  571 */       InteractivetaskInfo _o_ = InteractivetaskInfo.this;
/*  572 */       List<Integer> finished_graphids = new LinkedList();
/*  573 */       finished_graphids.addAll(_o_.finished_graphids);
/*  574 */       return finished_graphids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_graphid()
/*      */     {
/*  581 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  582 */       return InteractivetaskInfo.this.current_graphid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getRoleids()
/*      */     {
/*  589 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  590 */       return xdb.Consts.constSet(InteractivetaskInfo.this.roleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getRoleidsAsData()
/*      */     {
/*  596 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*      */       
/*  598 */       InteractivetaskInfo _o_ = InteractivetaskInfo.this;
/*  599 */       Set<Long> roleids = new SetX();
/*  600 */       roleids.addAll(_o_.roleids);
/*  601 */       return roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCommander_roleid()
/*      */     {
/*  608 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  609 */       return InteractivetaskInfo.this.commander_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionid()
/*      */     {
/*  616 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  617 */       return InteractivetaskInfo.this.sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorldid(long _v_)
/*      */     {
/*  624 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  625 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_graphid(int _v_)
/*      */     {
/*  632 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  633 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCommander_roleid(long _v_)
/*      */     {
/*  640 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  641 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionid(long _v_)
/*      */     {
/*  648 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  649 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  655 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  656 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  662 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  663 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  669 */       return InteractivetaskInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  675 */       return InteractivetaskInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  681 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  682 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  688 */       return InteractivetaskInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  694 */       return InteractivetaskInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  700 */       InteractivetaskInfo.this._xdb_verify_unsafe_();
/*  701 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  707 */       return InteractivetaskInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  713 */       return InteractivetaskInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  719 */       return InteractivetaskInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  725 */       return InteractivetaskInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  731 */       return InteractivetaskInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  737 */       return InteractivetaskInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  743 */       return InteractivetaskInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.InteractivetaskInfo
/*      */   {
/*      */     private long worldid;
/*      */     
/*      */     private LinkedList<Integer> finished_graphids;
/*      */     
/*      */     private int current_graphid;
/*      */     
/*      */     private HashSet<Long> roleids;
/*      */     
/*      */     private long commander_roleid;
/*      */     
/*      */     private long sessionid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  765 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  770 */       this.finished_graphids = new LinkedList();
/*  771 */       this.roleids = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.InteractivetaskInfo _o1_)
/*      */     {
/*  776 */       if ((_o1_ instanceof InteractivetaskInfo)) { assign((InteractivetaskInfo)_o1_);
/*  777 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  778 */       } else if ((_o1_ instanceof InteractivetaskInfo.Const)) assign(((InteractivetaskInfo.Const)_o1_).nThis()); else {
/*  779 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(InteractivetaskInfo _o_) {
/*  784 */       this.worldid = _o_.worldid;
/*  785 */       this.finished_graphids = new LinkedList();
/*  786 */       this.finished_graphids.addAll(_o_.finished_graphids);
/*  787 */       this.current_graphid = _o_.current_graphid;
/*  788 */       this.roleids = new HashSet();
/*  789 */       this.roleids.addAll(_o_.roleids);
/*  790 */       this.commander_roleid = _o_.commander_roleid;
/*  791 */       this.sessionid = _o_.sessionid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  796 */       this.worldid = _o_.worldid;
/*  797 */       this.finished_graphids = new LinkedList();
/*  798 */       this.finished_graphids.addAll(_o_.finished_graphids);
/*  799 */       this.current_graphid = _o_.current_graphid;
/*  800 */       this.roleids = new HashSet();
/*  801 */       this.roleids.addAll(_o_.roleids);
/*  802 */       this.commander_roleid = _o_.commander_roleid;
/*  803 */       this.sessionid = _o_.sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  809 */       _os_.marshal(this.worldid);
/*  810 */       _os_.compact_uint32(this.finished_graphids.size());
/*  811 */       for (Integer _v_ : this.finished_graphids)
/*      */       {
/*  813 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  815 */       _os_.marshal(this.current_graphid);
/*  816 */       _os_.compact_uint32(this.roleids.size());
/*  817 */       for (Long _v_ : this.roleids)
/*      */       {
/*  819 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  821 */       _os_.marshal(this.commander_roleid);
/*  822 */       _os_.marshal(this.sessionid);
/*  823 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  829 */       this.worldid = _os_.unmarshal_long();
/*  830 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  832 */         int _v_ = 0;
/*  833 */         _v_ = _os_.unmarshal_int();
/*  834 */         this.finished_graphids.add(Integer.valueOf(_v_));
/*      */       }
/*  836 */       this.current_graphid = _os_.unmarshal_int();
/*  837 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  839 */         long _v_ = 0L;
/*  840 */         _v_ = _os_.unmarshal_long();
/*  841 */         this.roleids.add(Long.valueOf(_v_));
/*      */       }
/*  843 */       this.commander_roleid = _os_.unmarshal_long();
/*  844 */       this.sessionid = _os_.unmarshal_long();
/*  845 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  851 */       int _size_ = 0;
/*  852 */       _size_ += CodedOutputStream.computeInt64Size(1, this.worldid);
/*  853 */       for (Integer _v_ : this.finished_graphids)
/*      */       {
/*  855 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */       }
/*  857 */       _size_ += CodedOutputStream.computeInt32Size(3, this.current_graphid);
/*  858 */       for (Long _v_ : this.roleids)
/*      */       {
/*  860 */         _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */       }
/*  862 */       _size_ += CodedOutputStream.computeInt64Size(5, this.commander_roleid);
/*  863 */       _size_ += CodedOutputStream.computeInt64Size(6, this.sessionid);
/*  864 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  872 */         _output_.writeInt64(1, this.worldid);
/*  873 */         for (Integer _v_ : this.finished_graphids)
/*      */         {
/*  875 */           _output_.writeInt32(2, _v_.intValue());
/*      */         }
/*  877 */         _output_.writeInt32(3, this.current_graphid);
/*  878 */         for (Long _v_ : this.roleids)
/*      */         {
/*  880 */           _output_.writeInt64(4, _v_.longValue());
/*      */         }
/*  882 */         _output_.writeInt64(5, this.commander_roleid);
/*  883 */         _output_.writeInt64(6, this.sessionid);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  887 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  889 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  897 */         boolean done = false;
/*  898 */         while (!done)
/*      */         {
/*  900 */           int tag = _input_.readTag();
/*  901 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  905 */             done = true;
/*  906 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  910 */             this.worldid = _input_.readInt64();
/*  911 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  915 */             int _v_ = 0;
/*  916 */             _v_ = _input_.readInt32();
/*  917 */             this.finished_graphids.add(Integer.valueOf(_v_));
/*  918 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  922 */             this.current_graphid = _input_.readInt32();
/*  923 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  927 */             long _v_ = 0L;
/*  928 */             _v_ = _input_.readInt64();
/*  929 */             this.roleids.add(Long.valueOf(_v_));
/*  930 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  934 */             this.commander_roleid = _input_.readInt64();
/*  935 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  939 */             this.sessionid = _input_.readInt64();
/*  940 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  944 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  946 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  955 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  959 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  961 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.InteractivetaskInfo copy()
/*      */     {
/*  967 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.InteractivetaskInfo toData()
/*      */     {
/*  973 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.InteractivetaskInfo toBean()
/*      */     {
/*  978 */       return new InteractivetaskInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.InteractivetaskInfo toDataIf()
/*      */     {
/*  984 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.InteractivetaskInfo toBeanIf()
/*      */     {
/*  989 */       return new InteractivetaskInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  995 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  999 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1003 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1007 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1011 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1015 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1019 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorldid()
/*      */     {
/* 1026 */       return this.worldid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getFinished_graphids()
/*      */     {
/* 1033 */       return this.finished_graphids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getFinished_graphidsAsData()
/*      */     {
/* 1040 */       return this.finished_graphids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_graphid()
/*      */     {
/* 1047 */       return this.current_graphid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getRoleids()
/*      */     {
/* 1054 */       return this.roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getRoleidsAsData()
/*      */     {
/* 1061 */       return this.roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCommander_roleid()
/*      */     {
/* 1068 */       return this.commander_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionid()
/*      */     {
/* 1075 */       return this.sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorldid(long _v_)
/*      */     {
/* 1082 */       this.worldid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_graphid(int _v_)
/*      */     {
/* 1089 */       this.current_graphid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCommander_roleid(long _v_)
/*      */     {
/* 1096 */       this.commander_roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionid(long _v_)
/*      */     {
/* 1103 */       this.sessionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1109 */       if (!(_o1_ instanceof Data)) return false;
/* 1110 */       Data _o_ = (Data)_o1_;
/* 1111 */       if (this.worldid != _o_.worldid) return false;
/* 1112 */       if (!this.finished_graphids.equals(_o_.finished_graphids)) return false;
/* 1113 */       if (this.current_graphid != _o_.current_graphid) return false;
/* 1114 */       if (!this.roleids.equals(_o_.roleids)) return false;
/* 1115 */       if (this.commander_roleid != _o_.commander_roleid) return false;
/* 1116 */       if (this.sessionid != _o_.sessionid) return false;
/* 1117 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1123 */       int _h_ = 0;
/* 1124 */       _h_ = (int)(_h_ + this.worldid);
/* 1125 */       _h_ += this.finished_graphids.hashCode();
/* 1126 */       _h_ += this.current_graphid;
/* 1127 */       _h_ += this.roleids.hashCode();
/* 1128 */       _h_ = (int)(_h_ + this.commander_roleid);
/* 1129 */       _h_ = (int)(_h_ + this.sessionid);
/* 1130 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1136 */       StringBuilder _sb_ = new StringBuilder();
/* 1137 */       _sb_.append("(");
/* 1138 */       _sb_.append(this.worldid);
/* 1139 */       _sb_.append(",");
/* 1140 */       _sb_.append(this.finished_graphids);
/* 1141 */       _sb_.append(",");
/* 1142 */       _sb_.append(this.current_graphid);
/* 1143 */       _sb_.append(",");
/* 1144 */       _sb_.append(this.roleids);
/* 1145 */       _sb_.append(",");
/* 1146 */       _sb_.append(this.commander_roleid);
/* 1147 */       _sb_.append(",");
/* 1148 */       _sb_.append(this.sessionid);
/* 1149 */       _sb_.append(")");
/* 1150 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\InteractivetaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */