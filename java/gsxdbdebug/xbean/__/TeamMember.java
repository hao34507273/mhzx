/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
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
/*      */ public final class TeamMember extends XBean implements xbean.TeamMember
/*      */ {
/*      */   private long roleid;
/*      */   private int status;
/*      */   private LinkedList<Long> invitees;
/*      */   private int tempstatus;
/*      */   private boolean istobefired;
/*      */   private boolean istobeoffline;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.roleid = 0L;
/*   29 */     this.status = 0;
/*   30 */     this.invitees.clear();
/*   31 */     this.tempstatus = 0;
/*   32 */     this.istobefired = false;
/*   33 */     this.istobeoffline = false;
/*      */   }
/*      */   
/*      */   TeamMember(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.invitees = new LinkedList();
/*   40 */     this.istobeoffline = false;
/*      */   }
/*      */   
/*      */   public TeamMember()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public TeamMember(TeamMember _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   TeamMember(xbean.TeamMember _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof TeamMember)) { assign((TeamMember)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(TeamMember _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.roleid = _o_.roleid;
/*   66 */     this.status = _o_.status;
/*   67 */     this.invitees = new LinkedList();
/*   68 */     this.invitees.addAll(_o_.invitees);
/*   69 */     this.tempstatus = _o_.tempstatus;
/*   70 */     this.istobefired = _o_.istobefired;
/*   71 */     this.istobeoffline = _o_.istobeoffline;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   76 */     this.roleid = _o_.roleid;
/*   77 */     this.status = _o_.status;
/*   78 */     this.invitees = new LinkedList();
/*   79 */     this.invitees.addAll(_o_.invitees);
/*   80 */     this.tempstatus = _o_.tempstatus;
/*   81 */     this.istobefired = _o_.istobefired;
/*   82 */     this.istobeoffline = _o_.istobeoffline;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   88 */     _xdb_verify_unsafe_();
/*   89 */     _os_.marshal(this.roleid);
/*   90 */     _os_.marshal(this.status);
/*   91 */     _os_.compact_uint32(this.invitees.size());
/*   92 */     for (Long _v_ : this.invitees)
/*      */     {
/*   94 */       _os_.marshal(_v_.longValue());
/*      */     }
/*   96 */     _os_.marshal(this.tempstatus);
/*   97 */     _os_.marshal(this.istobefired);
/*   98 */     _os_.marshal(this.istobeoffline);
/*   99 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     this.roleid = _os_.unmarshal_long();
/*  107 */     this.status = _os_.unmarshal_int();
/*  108 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  110 */       long _v_ = 0L;
/*  111 */       _v_ = _os_.unmarshal_long();
/*  112 */       this.invitees.add(Long.valueOf(_v_));
/*      */     }
/*  114 */     this.tempstatus = _os_.unmarshal_int();
/*  115 */     this.istobefired = _os_.unmarshal_boolean();
/*  116 */     this.istobeoffline = _os_.unmarshal_boolean();
/*  117 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  123 */     _xdb_verify_unsafe_();
/*  124 */     int _size_ = 0;
/*  125 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  126 */     _size_ += CodedOutputStream.computeInt32Size(2, this.status);
/*  127 */     for (Long _v_ : this.invitees)
/*      */     {
/*  129 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */     }
/*  131 */     _size_ += CodedOutputStream.computeInt32Size(4, this.tempstatus);
/*  132 */     _size_ += CodedOutputStream.computeBoolSize(5, this.istobefired);
/*  133 */     _size_ += CodedOutputStream.computeBoolSize(6, this.istobeoffline);
/*  134 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  143 */       _output_.writeInt64(1, this.roleid);
/*  144 */       _output_.writeInt32(2, this.status);
/*  145 */       for (Long _v_ : this.invitees)
/*      */       {
/*  147 */         _output_.writeInt64(3, _v_.longValue());
/*      */       }
/*  149 */       _output_.writeInt32(4, this.tempstatus);
/*  150 */       _output_.writeBool(5, this.istobefired);
/*  151 */       _output_.writeBool(6, this.istobeoffline);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  155 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  157 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  163 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  166 */       boolean done = false;
/*  167 */       while (!done)
/*      */       {
/*  169 */         int tag = _input_.readTag();
/*  170 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  174 */           done = true;
/*  175 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  179 */           this.roleid = _input_.readInt64();
/*  180 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  184 */           this.status = _input_.readInt32();
/*  185 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  189 */           long _v_ = 0L;
/*  190 */           _v_ = _input_.readInt64();
/*  191 */           this.invitees.add(Long.valueOf(_v_));
/*  192 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  196 */           this.tempstatus = _input_.readInt32();
/*  197 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  201 */           this.istobefired = _input_.readBool();
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  206 */           this.istobeoffline = _input_.readBool();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  211 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  213 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  222 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  226 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  228 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TeamMember copy()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new TeamMember(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TeamMember toData()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.TeamMember toBean()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new TeamMember(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TeamMember toDataIf()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.TeamMember toBeanIf()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStatus()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return this.status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getInvitees()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return Logs.logList(new LogKey(this, "invitees"), this.invitees);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getInviteesAsData()
/*      */   {
/*  298 */     _xdb_verify_unsafe_();
/*      */     
/*  300 */     TeamMember _o_ = this;
/*  301 */     List<Long> invitees = new LinkedList();
/*  302 */     invitees.addAll(_o_.invitees);
/*  303 */     return invitees;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTempstatus()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return this.tempstatus;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIstobefired()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return this.istobefired;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIstobeoffline()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return this.istobeoffline;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  339 */         new xdb.logs.LogLong(this, TeamMember.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  343 */             TeamMember.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  347 */     });
/*  348 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStatus(int _v_)
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     Logs.logIf(new LogKey(this, "status")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  360 */         new xdb.logs.LogInt(this, TeamMember.this.status)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  364 */             TeamMember.this.status = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  368 */     });
/*  369 */     this.status = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTempstatus(int _v_)
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     Logs.logIf(new LogKey(this, "tempstatus")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  381 */         new xdb.logs.LogInt(this, TeamMember.this.tempstatus)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  385 */             TeamMember.this.tempstatus = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  389 */     });
/*  390 */     this.tempstatus = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIstobefired(boolean _v_)
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     Logs.logIf(new LogKey(this, "istobefired")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  402 */         new xdb.logs.LogObject(this, Boolean.valueOf(TeamMember.this.istobefired))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  406 */             TeamMember.this.istobefired = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  410 */     });
/*  411 */     this.istobefired = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIstobeoffline(boolean _v_)
/*      */   {
/*  418 */     _xdb_verify_unsafe_();
/*  419 */     Logs.logIf(new LogKey(this, "istobeoffline")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  423 */         new xdb.logs.LogObject(this, Boolean.valueOf(TeamMember.this.istobeoffline))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  427 */             TeamMember.this.istobeoffline = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  431 */     });
/*  432 */     this.istobeoffline = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  438 */     _xdb_verify_unsafe_();
/*  439 */     TeamMember _o_ = null;
/*  440 */     if ((_o1_ instanceof TeamMember)) { _o_ = (TeamMember)_o1_;
/*  441 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  442 */       return false;
/*  443 */     if (this.roleid != _o_.roleid) return false;
/*  444 */     if (this.status != _o_.status) return false;
/*  445 */     if (!this.invitees.equals(_o_.invitees)) return false;
/*  446 */     if (this.tempstatus != _o_.tempstatus) return false;
/*  447 */     if (this.istobefired != _o_.istobefired) return false;
/*  448 */     if (this.istobeoffline != _o_.istobeoffline) return false;
/*  449 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  455 */     _xdb_verify_unsafe_();
/*  456 */     int _h_ = 0;
/*  457 */     _h_ = (int)(_h_ + this.roleid);
/*  458 */     _h_ += this.status;
/*  459 */     _h_ += this.invitees.hashCode();
/*  460 */     _h_ += this.tempstatus;
/*  461 */     _h_ += (this.istobefired ? 1231 : 1237);
/*  462 */     _h_ += (this.istobeoffline ? 1231 : 1237);
/*  463 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  469 */     _xdb_verify_unsafe_();
/*  470 */     StringBuilder _sb_ = new StringBuilder();
/*  471 */     _sb_.append("(");
/*  472 */     _sb_.append(this.roleid);
/*  473 */     _sb_.append(",");
/*  474 */     _sb_.append(this.status);
/*  475 */     _sb_.append(",");
/*  476 */     _sb_.append(this.invitees);
/*  477 */     _sb_.append(",");
/*  478 */     _sb_.append(this.tempstatus);
/*  479 */     _sb_.append(",");
/*  480 */     _sb_.append(this.istobefired);
/*  481 */     _sb_.append(",");
/*  482 */     _sb_.append(this.istobeoffline);
/*  483 */     _sb_.append(")");
/*  484 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  490 */     ListenableBean lb = new ListenableBean();
/*  491 */     lb.add(new ListenableChanged().setVarName("roleid"));
/*  492 */     lb.add(new ListenableChanged().setVarName("status"));
/*  493 */     lb.add(new ListenableChanged().setVarName("invitees"));
/*  494 */     lb.add(new ListenableChanged().setVarName("tempstatus"));
/*  495 */     lb.add(new ListenableChanged().setVarName("istobefired"));
/*  496 */     lb.add(new ListenableChanged().setVarName("istobeoffline"));
/*  497 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.TeamMember {
/*      */     private Const() {}
/*      */     
/*      */     TeamMember nThis() {
/*  504 */       return TeamMember.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  510 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TeamMember copy()
/*      */     {
/*  516 */       return TeamMember.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TeamMember toData()
/*      */     {
/*  522 */       return TeamMember.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.TeamMember toBean()
/*      */     {
/*  527 */       return TeamMember.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TeamMember toDataIf()
/*      */     {
/*  533 */       return TeamMember.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.TeamMember toBeanIf()
/*      */     {
/*  538 */       return TeamMember.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  545 */       TeamMember.this._xdb_verify_unsafe_();
/*  546 */       return TeamMember.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatus()
/*      */     {
/*  553 */       TeamMember.this._xdb_verify_unsafe_();
/*  554 */       return TeamMember.this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getInvitees()
/*      */     {
/*  561 */       TeamMember.this._xdb_verify_unsafe_();
/*  562 */       return xdb.Consts.constList(TeamMember.this.invitees);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getInviteesAsData()
/*      */     {
/*  568 */       TeamMember.this._xdb_verify_unsafe_();
/*      */       
/*  570 */       TeamMember _o_ = TeamMember.this;
/*  571 */       List<Long> invitees = new LinkedList();
/*  572 */       invitees.addAll(_o_.invitees);
/*  573 */       return invitees;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTempstatus()
/*      */     {
/*  580 */       TeamMember.this._xdb_verify_unsafe_();
/*  581 */       return TeamMember.this.tempstatus;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIstobefired()
/*      */     {
/*  588 */       TeamMember.this._xdb_verify_unsafe_();
/*  589 */       return TeamMember.this.istobefired;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIstobeoffline()
/*      */     {
/*  596 */       TeamMember.this._xdb_verify_unsafe_();
/*  597 */       return TeamMember.this.istobeoffline;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  604 */       TeamMember.this._xdb_verify_unsafe_();
/*  605 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/*  612 */       TeamMember.this._xdb_verify_unsafe_();
/*  613 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTempstatus(int _v_)
/*      */     {
/*  620 */       TeamMember.this._xdb_verify_unsafe_();
/*  621 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIstobefired(boolean _v_)
/*      */     {
/*  628 */       TeamMember.this._xdb_verify_unsafe_();
/*  629 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIstobeoffline(boolean _v_)
/*      */     {
/*  636 */       TeamMember.this._xdb_verify_unsafe_();
/*  637 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  643 */       TeamMember.this._xdb_verify_unsafe_();
/*  644 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  650 */       TeamMember.this._xdb_verify_unsafe_();
/*  651 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  657 */       return TeamMember.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  663 */       return TeamMember.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  669 */       TeamMember.this._xdb_verify_unsafe_();
/*  670 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  676 */       return TeamMember.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  682 */       return TeamMember.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  688 */       TeamMember.this._xdb_verify_unsafe_();
/*  689 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  695 */       return TeamMember.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  701 */       return TeamMember.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  707 */       return TeamMember.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  713 */       return TeamMember.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  719 */       return TeamMember.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  725 */       return TeamMember.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  731 */       return TeamMember.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.TeamMember
/*      */   {
/*      */     private long roleid;
/*      */     
/*      */     private int status;
/*      */     
/*      */     private LinkedList<Long> invitees;
/*      */     
/*      */     private int tempstatus;
/*      */     
/*      */     private boolean istobefired;
/*      */     
/*      */     private boolean istobeoffline;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  753 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  758 */       this.invitees = new LinkedList();
/*  759 */       this.istobeoffline = false;
/*      */     }
/*      */     
/*      */     Data(xbean.TeamMember _o1_)
/*      */     {
/*  764 */       if ((_o1_ instanceof TeamMember)) { assign((TeamMember)_o1_);
/*  765 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  766 */       } else if ((_o1_ instanceof TeamMember.Const)) assign(((TeamMember.Const)_o1_).nThis()); else {
/*  767 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(TeamMember _o_) {
/*  772 */       this.roleid = _o_.roleid;
/*  773 */       this.status = _o_.status;
/*  774 */       this.invitees = new LinkedList();
/*  775 */       this.invitees.addAll(_o_.invitees);
/*  776 */       this.tempstatus = _o_.tempstatus;
/*  777 */       this.istobefired = _o_.istobefired;
/*  778 */       this.istobeoffline = _o_.istobeoffline;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  783 */       this.roleid = _o_.roleid;
/*  784 */       this.status = _o_.status;
/*  785 */       this.invitees = new LinkedList();
/*  786 */       this.invitees.addAll(_o_.invitees);
/*  787 */       this.tempstatus = _o_.tempstatus;
/*  788 */       this.istobefired = _o_.istobefired;
/*  789 */       this.istobeoffline = _o_.istobeoffline;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  795 */       _os_.marshal(this.roleid);
/*  796 */       _os_.marshal(this.status);
/*  797 */       _os_.compact_uint32(this.invitees.size());
/*  798 */       for (Long _v_ : this.invitees)
/*      */       {
/*  800 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  802 */       _os_.marshal(this.tempstatus);
/*  803 */       _os_.marshal(this.istobefired);
/*  804 */       _os_.marshal(this.istobeoffline);
/*  805 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  811 */       this.roleid = _os_.unmarshal_long();
/*  812 */       this.status = _os_.unmarshal_int();
/*  813 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  815 */         long _v_ = 0L;
/*  816 */         _v_ = _os_.unmarshal_long();
/*  817 */         this.invitees.add(Long.valueOf(_v_));
/*      */       }
/*  819 */       this.tempstatus = _os_.unmarshal_int();
/*  820 */       this.istobefired = _os_.unmarshal_boolean();
/*  821 */       this.istobeoffline = _os_.unmarshal_boolean();
/*  822 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  828 */       int _size_ = 0;
/*  829 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  830 */       _size_ += CodedOutputStream.computeInt32Size(2, this.status);
/*  831 */       for (Long _v_ : this.invitees)
/*      */       {
/*  833 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */       }
/*  835 */       _size_ += CodedOutputStream.computeInt32Size(4, this.tempstatus);
/*  836 */       _size_ += CodedOutputStream.computeBoolSize(5, this.istobefired);
/*  837 */       _size_ += CodedOutputStream.computeBoolSize(6, this.istobeoffline);
/*  838 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  846 */         _output_.writeInt64(1, this.roleid);
/*  847 */         _output_.writeInt32(2, this.status);
/*  848 */         for (Long _v_ : this.invitees)
/*      */         {
/*  850 */           _output_.writeInt64(3, _v_.longValue());
/*      */         }
/*  852 */         _output_.writeInt32(4, this.tempstatus);
/*  853 */         _output_.writeBool(5, this.istobefired);
/*  854 */         _output_.writeBool(6, this.istobeoffline);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  858 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  860 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  868 */         boolean done = false;
/*  869 */         while (!done)
/*      */         {
/*  871 */           int tag = _input_.readTag();
/*  872 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  876 */             done = true;
/*  877 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  881 */             this.roleid = _input_.readInt64();
/*  882 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  886 */             this.status = _input_.readInt32();
/*  887 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  891 */             long _v_ = 0L;
/*  892 */             _v_ = _input_.readInt64();
/*  893 */             this.invitees.add(Long.valueOf(_v_));
/*  894 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  898 */             this.tempstatus = _input_.readInt32();
/*  899 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  903 */             this.istobefired = _input_.readBool();
/*  904 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  908 */             this.istobeoffline = _input_.readBool();
/*  909 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  913 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  915 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  924 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  928 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  930 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TeamMember copy()
/*      */     {
/*  936 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TeamMember toData()
/*      */     {
/*  942 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.TeamMember toBean()
/*      */     {
/*  947 */       return new TeamMember(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TeamMember toDataIf()
/*      */     {
/*  953 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.TeamMember toBeanIf()
/*      */     {
/*  958 */       return new TeamMember(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  964 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  968 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  972 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  976 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  980 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  984 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  988 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  995 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatus()
/*      */     {
/* 1002 */       return this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getInvitees()
/*      */     {
/* 1009 */       return this.invitees;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getInviteesAsData()
/*      */     {
/* 1016 */       return this.invitees;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTempstatus()
/*      */     {
/* 1023 */       return this.tempstatus;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIstobefired()
/*      */     {
/* 1030 */       return this.istobefired;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIstobeoffline()
/*      */     {
/* 1037 */       return this.istobeoffline;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1044 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/* 1051 */       this.status = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTempstatus(int _v_)
/*      */     {
/* 1058 */       this.tempstatus = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIstobefired(boolean _v_)
/*      */     {
/* 1065 */       this.istobefired = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIstobeoffline(boolean _v_)
/*      */     {
/* 1072 */       this.istobeoffline = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1078 */       if (!(_o1_ instanceof Data)) return false;
/* 1079 */       Data _o_ = (Data)_o1_;
/* 1080 */       if (this.roleid != _o_.roleid) return false;
/* 1081 */       if (this.status != _o_.status) return false;
/* 1082 */       if (!this.invitees.equals(_o_.invitees)) return false;
/* 1083 */       if (this.tempstatus != _o_.tempstatus) return false;
/* 1084 */       if (this.istobefired != _o_.istobefired) return false;
/* 1085 */       if (this.istobeoffline != _o_.istobeoffline) return false;
/* 1086 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1092 */       int _h_ = 0;
/* 1093 */       _h_ = (int)(_h_ + this.roleid);
/* 1094 */       _h_ += this.status;
/* 1095 */       _h_ += this.invitees.hashCode();
/* 1096 */       _h_ += this.tempstatus;
/* 1097 */       _h_ += (this.istobefired ? 1231 : 1237);
/* 1098 */       _h_ += (this.istobeoffline ? 1231 : 1237);
/* 1099 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1105 */       StringBuilder _sb_ = new StringBuilder();
/* 1106 */       _sb_.append("(");
/* 1107 */       _sb_.append(this.roleid);
/* 1108 */       _sb_.append(",");
/* 1109 */       _sb_.append(this.status);
/* 1110 */       _sb_.append(",");
/* 1111 */       _sb_.append(this.invitees);
/* 1112 */       _sb_.append(",");
/* 1113 */       _sb_.append(this.tempstatus);
/* 1114 */       _sb_.append(",");
/* 1115 */       _sb_.append(this.istobefired);
/* 1116 */       _sb_.append(",");
/* 1117 */       _sb_.append(this.istobeoffline);
/* 1118 */       _sb_.append(")");
/* 1119 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\TeamMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */