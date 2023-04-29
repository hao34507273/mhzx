/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class TaskConfBean extends XBean implements xbean.TaskConfBean
/*      */ {
/*      */   private int graphid;
/*      */   private int taskid;
/*      */   private long leaderid;
/*      */   private int battleid;
/*      */   private ArrayList<Long> allroles;
/*      */   private ArrayList<Long> acceptroles;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.graphid = 0;
/*   29 */     this.taskid = 0;
/*   30 */     this.leaderid = 0L;
/*   31 */     this.battleid = 0;
/*   32 */     this.allroles.clear();
/*   33 */     this.acceptroles.clear();
/*      */   }
/*      */   
/*      */   TaskConfBean(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.allroles = new ArrayList();
/*   40 */     this.acceptroles = new ArrayList();
/*      */   }
/*      */   
/*      */   public TaskConfBean()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public TaskConfBean(TaskConfBean _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   TaskConfBean(xbean.TaskConfBean _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof TaskConfBean)) { assign((TaskConfBean)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(TaskConfBean _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.graphid = _o_.graphid;
/*   66 */     this.taskid = _o_.taskid;
/*   67 */     this.leaderid = _o_.leaderid;
/*   68 */     this.battleid = _o_.battleid;
/*   69 */     this.allroles = new ArrayList();
/*   70 */     this.allroles.addAll(_o_.allroles);
/*   71 */     this.acceptroles = new ArrayList();
/*   72 */     this.acceptroles.addAll(_o_.acceptroles);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   77 */     this.graphid = _o_.graphid;
/*   78 */     this.taskid = _o_.taskid;
/*   79 */     this.leaderid = _o_.leaderid;
/*   80 */     this.battleid = _o_.battleid;
/*   81 */     this.allroles = new ArrayList();
/*   82 */     this.allroles.addAll(_o_.allroles);
/*   83 */     this.acceptroles = new ArrayList();
/*   84 */     this.acceptroles.addAll(_o_.acceptroles);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     _os_.marshal(this.graphid);
/*   92 */     _os_.marshal(this.taskid);
/*   93 */     _os_.marshal(this.leaderid);
/*   94 */     _os_.marshal(this.battleid);
/*   95 */     _os_.compact_uint32(this.allroles.size());
/*   96 */     for (Long _v_ : this.allroles)
/*      */     {
/*   98 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  100 */     _os_.compact_uint32(this.acceptroles.size());
/*  101 */     for (Long _v_ : this.acceptroles)
/*      */     {
/*  103 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  105 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  111 */     _xdb_verify_unsafe_();
/*  112 */     this.graphid = _os_.unmarshal_int();
/*  113 */     this.taskid = _os_.unmarshal_int();
/*  114 */     this.leaderid = _os_.unmarshal_long();
/*  115 */     this.battleid = _os_.unmarshal_int();
/*  116 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  118 */       long _v_ = 0L;
/*  119 */       _v_ = _os_.unmarshal_long();
/*  120 */       this.allroles.add(Long.valueOf(_v_));
/*      */     }
/*  122 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  124 */       long _v_ = 0L;
/*  125 */       _v_ = _os_.unmarshal_long();
/*  126 */       this.acceptroles.add(Long.valueOf(_v_));
/*      */     }
/*  128 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  134 */     _xdb_verify_unsafe_();
/*  135 */     int _size_ = 0;
/*  136 */     _size_ += CodedOutputStream.computeInt32Size(1, this.graphid);
/*  137 */     _size_ += CodedOutputStream.computeInt32Size(2, this.taskid);
/*  138 */     _size_ += CodedOutputStream.computeInt64Size(3, this.leaderid);
/*  139 */     _size_ += CodedOutputStream.computeInt32Size(4, this.battleid);
/*  140 */     for (Long _v_ : this.allroles)
/*      */     {
/*  142 */       _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */     }
/*  144 */     for (Long _v_ : this.acceptroles)
/*      */     {
/*  146 */       _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */     }
/*  148 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  154 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  157 */       _output_.writeInt32(1, this.graphid);
/*  158 */       _output_.writeInt32(2, this.taskid);
/*  159 */       _output_.writeInt64(3, this.leaderid);
/*  160 */       _output_.writeInt32(4, this.battleid);
/*  161 */       for (Long _v_ : this.allroles)
/*      */       {
/*  163 */         _output_.writeInt64(5, _v_.longValue());
/*      */       }
/*  165 */       for (Long _v_ : this.acceptroles)
/*      */       {
/*  167 */         _output_.writeInt64(6, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
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
/*  196 */           this.graphid = _input_.readInt32();
/*  197 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  201 */           this.taskid = _input_.readInt32();
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  206 */           this.leaderid = _input_.readInt64();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  211 */           this.battleid = _input_.readInt32();
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  216 */           long _v_ = 0L;
/*  217 */           _v_ = _input_.readInt64();
/*  218 */           this.allroles.add(Long.valueOf(_v_));
/*  219 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  223 */           long _v_ = 0L;
/*  224 */           _v_ = _input_.readInt64();
/*  225 */           this.acceptroles.add(Long.valueOf(_v_));
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
/*      */     catch (IOException e)
/*      */     {
/*  245 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  247 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TaskConfBean copy()
/*      */   {
/*  253 */     _xdb_verify_unsafe_();
/*  254 */     return new TaskConfBean(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TaskConfBean toData()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.TaskConfBean toBean()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return new TaskConfBean(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TaskConfBean toDataIf()
/*      */   {
/*  273 */     _xdb_verify_unsafe_();
/*  274 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.TaskConfBean toBeanIf()
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
/*      */   public int getGraphid()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return this.graphid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTaskid()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return this.taskid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLeaderid()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return this.leaderid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBattleid()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return this.battleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getAllroles()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return Logs.logList(new LogKey(this, "allroles"), this.allroles);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getAllrolesAsData()
/*      */   {
/*  333 */     _xdb_verify_unsafe_();
/*      */     
/*  335 */     TaskConfBean _o_ = this;
/*  336 */     List<Long> allroles = new ArrayList();
/*  337 */     allroles.addAll(_o_.allroles);
/*  338 */     return allroles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getAcceptroles()
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     return Logs.logList(new LogKey(this, "acceptroles"), this.acceptroles);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getAcceptrolesAsData()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*      */     
/*  354 */     TaskConfBean _o_ = this;
/*  355 */     List<Long> acceptroles = new ArrayList();
/*  356 */     acceptroles.addAll(_o_.acceptroles);
/*  357 */     return acceptroles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGraphid(int _v_)
/*      */   {
/*  364 */     _xdb_verify_unsafe_();
/*  365 */     Logs.logIf(new LogKey(this, "graphid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  369 */         new LogInt(this, TaskConfBean.this.graphid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  373 */             TaskConfBean.this.graphid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  377 */     });
/*  378 */     this.graphid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTaskid(int _v_)
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     Logs.logIf(new LogKey(this, "taskid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  390 */         new LogInt(this, TaskConfBean.this.taskid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  394 */             TaskConfBean.this.taskid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  398 */     });
/*  399 */     this.taskid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLeaderid(long _v_)
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     Logs.logIf(new LogKey(this, "leaderid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  411 */         new xdb.logs.LogLong(this, TaskConfBean.this.leaderid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  415 */             TaskConfBean.this.leaderid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  419 */     });
/*  420 */     this.leaderid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBattleid(int _v_)
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     Logs.logIf(new LogKey(this, "battleid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  432 */         new LogInt(this, TaskConfBean.this.battleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  436 */             TaskConfBean.this.battleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  440 */     });
/*  441 */     this.battleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  447 */     _xdb_verify_unsafe_();
/*  448 */     TaskConfBean _o_ = null;
/*  449 */     if ((_o1_ instanceof TaskConfBean)) { _o_ = (TaskConfBean)_o1_;
/*  450 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  451 */       return false;
/*  452 */     if (this.graphid != _o_.graphid) return false;
/*  453 */     if (this.taskid != _o_.taskid) return false;
/*  454 */     if (this.leaderid != _o_.leaderid) return false;
/*  455 */     if (this.battleid != _o_.battleid) return false;
/*  456 */     if (!this.allroles.equals(_o_.allroles)) return false;
/*  457 */     if (!this.acceptroles.equals(_o_.acceptroles)) return false;
/*  458 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*  465 */     int _h_ = 0;
/*  466 */     _h_ += this.graphid;
/*  467 */     _h_ += this.taskid;
/*  468 */     _h_ = (int)(_h_ + this.leaderid);
/*  469 */     _h_ += this.battleid;
/*  470 */     _h_ += this.allroles.hashCode();
/*  471 */     _h_ += this.acceptroles.hashCode();
/*  472 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  478 */     _xdb_verify_unsafe_();
/*  479 */     StringBuilder _sb_ = new StringBuilder();
/*  480 */     _sb_.append("(");
/*  481 */     _sb_.append(this.graphid);
/*  482 */     _sb_.append(",");
/*  483 */     _sb_.append(this.taskid);
/*  484 */     _sb_.append(",");
/*  485 */     _sb_.append(this.leaderid);
/*  486 */     _sb_.append(",");
/*  487 */     _sb_.append(this.battleid);
/*  488 */     _sb_.append(",");
/*  489 */     _sb_.append(this.allroles);
/*  490 */     _sb_.append(",");
/*  491 */     _sb_.append(this.acceptroles);
/*  492 */     _sb_.append(")");
/*  493 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  499 */     ListenableBean lb = new ListenableBean();
/*  500 */     lb.add(new ListenableChanged().setVarName("graphid"));
/*  501 */     lb.add(new ListenableChanged().setVarName("taskid"));
/*  502 */     lb.add(new ListenableChanged().setVarName("leaderid"));
/*  503 */     lb.add(new ListenableChanged().setVarName("battleid"));
/*  504 */     lb.add(new ListenableChanged().setVarName("allroles"));
/*  505 */     lb.add(new ListenableChanged().setVarName("acceptroles"));
/*  506 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.TaskConfBean {
/*      */     private Const() {}
/*      */     
/*      */     TaskConfBean nThis() {
/*  513 */       return TaskConfBean.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  519 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TaskConfBean copy()
/*      */     {
/*  525 */       return TaskConfBean.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TaskConfBean toData()
/*      */     {
/*  531 */       return TaskConfBean.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.TaskConfBean toBean()
/*      */     {
/*  536 */       return TaskConfBean.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TaskConfBean toDataIf()
/*      */     {
/*  542 */       return TaskConfBean.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.TaskConfBean toBeanIf()
/*      */     {
/*  547 */       return TaskConfBean.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGraphid()
/*      */     {
/*  554 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  555 */       return TaskConfBean.this.graphid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTaskid()
/*      */     {
/*  562 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  563 */       return TaskConfBean.this.taskid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLeaderid()
/*      */     {
/*  570 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  571 */       return TaskConfBean.this.leaderid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBattleid()
/*      */     {
/*  578 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  579 */       return TaskConfBean.this.battleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAllroles()
/*      */     {
/*  586 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  587 */       return xdb.Consts.constList(TaskConfBean.this.allroles);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getAllrolesAsData()
/*      */     {
/*  593 */       TaskConfBean.this._xdb_verify_unsafe_();
/*      */       
/*  595 */       TaskConfBean _o_ = TaskConfBean.this;
/*  596 */       List<Long> allroles = new ArrayList();
/*  597 */       allroles.addAll(_o_.allroles);
/*  598 */       return allroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAcceptroles()
/*      */     {
/*  605 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  606 */       return xdb.Consts.constList(TaskConfBean.this.acceptroles);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getAcceptrolesAsData()
/*      */     {
/*  612 */       TaskConfBean.this._xdb_verify_unsafe_();
/*      */       
/*  614 */       TaskConfBean _o_ = TaskConfBean.this;
/*  615 */       List<Long> acceptroles = new ArrayList();
/*  616 */       acceptroles.addAll(_o_.acceptroles);
/*  617 */       return acceptroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGraphid(int _v_)
/*      */     {
/*  624 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  625 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTaskid(int _v_)
/*      */     {
/*  632 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  633 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLeaderid(long _v_)
/*      */     {
/*  640 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  641 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBattleid(int _v_)
/*      */     {
/*  648 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  649 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  655 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  656 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  662 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  663 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  669 */       return TaskConfBean.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  675 */       return TaskConfBean.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  681 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  682 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  688 */       return TaskConfBean.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  694 */       return TaskConfBean.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  700 */       TaskConfBean.this._xdb_verify_unsafe_();
/*  701 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  707 */       return TaskConfBean.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  713 */       return TaskConfBean.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  719 */       return TaskConfBean.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  725 */       return TaskConfBean.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  731 */       return TaskConfBean.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  737 */       return TaskConfBean.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  743 */       return TaskConfBean.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.TaskConfBean
/*      */   {
/*      */     private int graphid;
/*      */     
/*      */     private int taskid;
/*      */     
/*      */     private long leaderid;
/*      */     
/*      */     private int battleid;
/*      */     
/*      */     private ArrayList<Long> allroles;
/*      */     
/*      */     private ArrayList<Long> acceptroles;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  765 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  770 */       this.allroles = new ArrayList();
/*  771 */       this.acceptroles = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.TaskConfBean _o1_)
/*      */     {
/*  776 */       if ((_o1_ instanceof TaskConfBean)) { assign((TaskConfBean)_o1_);
/*  777 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  778 */       } else if ((_o1_ instanceof TaskConfBean.Const)) assign(((TaskConfBean.Const)_o1_).nThis()); else {
/*  779 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(TaskConfBean _o_) {
/*  784 */       this.graphid = _o_.graphid;
/*  785 */       this.taskid = _o_.taskid;
/*  786 */       this.leaderid = _o_.leaderid;
/*  787 */       this.battleid = _o_.battleid;
/*  788 */       this.allroles = new ArrayList();
/*  789 */       this.allroles.addAll(_o_.allroles);
/*  790 */       this.acceptroles = new ArrayList();
/*  791 */       this.acceptroles.addAll(_o_.acceptroles);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  796 */       this.graphid = _o_.graphid;
/*  797 */       this.taskid = _o_.taskid;
/*  798 */       this.leaderid = _o_.leaderid;
/*  799 */       this.battleid = _o_.battleid;
/*  800 */       this.allroles = new ArrayList();
/*  801 */       this.allroles.addAll(_o_.allroles);
/*  802 */       this.acceptroles = new ArrayList();
/*  803 */       this.acceptroles.addAll(_o_.acceptroles);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  809 */       _os_.marshal(this.graphid);
/*  810 */       _os_.marshal(this.taskid);
/*  811 */       _os_.marshal(this.leaderid);
/*  812 */       _os_.marshal(this.battleid);
/*  813 */       _os_.compact_uint32(this.allroles.size());
/*  814 */       for (Long _v_ : this.allroles)
/*      */       {
/*  816 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  818 */       _os_.compact_uint32(this.acceptroles.size());
/*  819 */       for (Long _v_ : this.acceptroles)
/*      */       {
/*  821 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  823 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  829 */       this.graphid = _os_.unmarshal_int();
/*  830 */       this.taskid = _os_.unmarshal_int();
/*  831 */       this.leaderid = _os_.unmarshal_long();
/*  832 */       this.battleid = _os_.unmarshal_int();
/*  833 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  835 */         long _v_ = 0L;
/*  836 */         _v_ = _os_.unmarshal_long();
/*  837 */         this.allroles.add(Long.valueOf(_v_));
/*      */       }
/*  839 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  841 */         long _v_ = 0L;
/*  842 */         _v_ = _os_.unmarshal_long();
/*  843 */         this.acceptroles.add(Long.valueOf(_v_));
/*      */       }
/*  845 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  851 */       int _size_ = 0;
/*  852 */       _size_ += CodedOutputStream.computeInt32Size(1, this.graphid);
/*  853 */       _size_ += CodedOutputStream.computeInt32Size(2, this.taskid);
/*  854 */       _size_ += CodedOutputStream.computeInt64Size(3, this.leaderid);
/*  855 */       _size_ += CodedOutputStream.computeInt32Size(4, this.battleid);
/*  856 */       for (Long _v_ : this.allroles)
/*      */       {
/*  858 */         _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */       }
/*  860 */       for (Long _v_ : this.acceptroles)
/*      */       {
/*  862 */         _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */       }
/*  864 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  872 */         _output_.writeInt32(1, this.graphid);
/*  873 */         _output_.writeInt32(2, this.taskid);
/*  874 */         _output_.writeInt64(3, this.leaderid);
/*  875 */         _output_.writeInt32(4, this.battleid);
/*  876 */         for (Long _v_ : this.allroles)
/*      */         {
/*  878 */           _output_.writeInt64(5, _v_.longValue());
/*      */         }
/*  880 */         for (Long _v_ : this.acceptroles)
/*      */         {
/*  882 */           _output_.writeInt64(6, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
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
/*  910 */             this.graphid = _input_.readInt32();
/*  911 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  915 */             this.taskid = _input_.readInt32();
/*  916 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  920 */             this.leaderid = _input_.readInt64();
/*  921 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  925 */             this.battleid = _input_.readInt32();
/*  926 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  930 */             long _v_ = 0L;
/*  931 */             _v_ = _input_.readInt64();
/*  932 */             this.allroles.add(Long.valueOf(_v_));
/*  933 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  937 */             long _v_ = 0L;
/*  938 */             _v_ = _input_.readInt64();
/*  939 */             this.acceptroles.add(Long.valueOf(_v_));
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
/*      */       catch (IOException e)
/*      */       {
/*  959 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  961 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TaskConfBean copy()
/*      */     {
/*  967 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TaskConfBean toData()
/*      */     {
/*  973 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.TaskConfBean toBean()
/*      */     {
/*  978 */       return new TaskConfBean(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TaskConfBean toDataIf()
/*      */     {
/*  984 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.TaskConfBean toBeanIf()
/*      */     {
/*  989 */       return new TaskConfBean(this, null, null);
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
/*      */     public int getGraphid()
/*      */     {
/* 1026 */       return this.graphid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTaskid()
/*      */     {
/* 1033 */       return this.taskid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLeaderid()
/*      */     {
/* 1040 */       return this.leaderid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBattleid()
/*      */     {
/* 1047 */       return this.battleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAllroles()
/*      */     {
/* 1054 */       return this.allroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAllrolesAsData()
/*      */     {
/* 1061 */       return this.allroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAcceptroles()
/*      */     {
/* 1068 */       return this.acceptroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAcceptrolesAsData()
/*      */     {
/* 1075 */       return this.acceptroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGraphid(int _v_)
/*      */     {
/* 1082 */       this.graphid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTaskid(int _v_)
/*      */     {
/* 1089 */       this.taskid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLeaderid(long _v_)
/*      */     {
/* 1096 */       this.leaderid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBattleid(int _v_)
/*      */     {
/* 1103 */       this.battleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1109 */       if (!(_o1_ instanceof Data)) return false;
/* 1110 */       Data _o_ = (Data)_o1_;
/* 1111 */       if (this.graphid != _o_.graphid) return false;
/* 1112 */       if (this.taskid != _o_.taskid) return false;
/* 1113 */       if (this.leaderid != _o_.leaderid) return false;
/* 1114 */       if (this.battleid != _o_.battleid) return false;
/* 1115 */       if (!this.allroles.equals(_o_.allroles)) return false;
/* 1116 */       if (!this.acceptroles.equals(_o_.acceptroles)) return false;
/* 1117 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1123 */       int _h_ = 0;
/* 1124 */       _h_ += this.graphid;
/* 1125 */       _h_ += this.taskid;
/* 1126 */       _h_ = (int)(_h_ + this.leaderid);
/* 1127 */       _h_ += this.battleid;
/* 1128 */       _h_ += this.allroles.hashCode();
/* 1129 */       _h_ += this.acceptroles.hashCode();
/* 1130 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1136 */       StringBuilder _sb_ = new StringBuilder();
/* 1137 */       _sb_.append("(");
/* 1138 */       _sb_.append(this.graphid);
/* 1139 */       _sb_.append(",");
/* 1140 */       _sb_.append(this.taskid);
/* 1141 */       _sb_.append(",");
/* 1142 */       _sb_.append(this.leaderid);
/* 1143 */       _sb_.append(",");
/* 1144 */       _sb_.append(this.battleid);
/* 1145 */       _sb_.append(",");
/* 1146 */       _sb_.append(this.allroles);
/* 1147 */       _sb_.append(",");
/* 1148 */       _sb_.append(this.acceptroles);
/* 1149 */       _sb_.append(")");
/* 1150 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\TaskConfBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */