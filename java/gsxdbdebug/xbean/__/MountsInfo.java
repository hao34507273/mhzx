/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class MountsInfo extends XBean implements xbean.MountsInfo
/*      */ {
/*      */   private int mounts_cfg_id;
/*      */   private int mounts_rank;
/*      */   private int mounts_dye_color_id;
/*      */   private ArrayList<xbean.PassiveSkillInfo> mounts_passive_skill_list;
/*      */   private int current_mounts_star_level;
/*      */   private int current_max_star_num;
/*      */   private int current_score;
/*      */   private int current_ornament_rank;
/*      */   private int protect_pet_expand_size;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   34 */     this.mounts_cfg_id = 0;
/*   35 */     this.mounts_rank = 0;
/*   36 */     this.mounts_dye_color_id = 0;
/*   37 */     this.mounts_passive_skill_list.clear();
/*   38 */     this.current_mounts_star_level = 0;
/*   39 */     this.current_max_star_num = 0;
/*   40 */     this.current_score = 0;
/*   41 */     this.current_ornament_rank = 0;
/*   42 */     this.protect_pet_expand_size = 0;
/*      */   }
/*      */   
/*      */   MountsInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   47 */     super(_xp_, _vn_);
/*   48 */     this.mounts_passive_skill_list = new ArrayList();
/*   49 */     this.protect_pet_expand_size = 0;
/*      */   }
/*      */   
/*      */   public MountsInfo()
/*      */   {
/*   54 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MountsInfo(MountsInfo _o_)
/*      */   {
/*   59 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MountsInfo(xbean.MountsInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   64 */     super(_xp_, _vn_);
/*   65 */     if ((_o1_ instanceof MountsInfo)) { assign((MountsInfo)_o1_);
/*   66 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   67 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   68 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MountsInfo _o_) {
/*   73 */     _o_._xdb_verify_unsafe_();
/*   74 */     this.mounts_cfg_id = _o_.mounts_cfg_id;
/*   75 */     this.mounts_rank = _o_.mounts_rank;
/*   76 */     this.mounts_dye_color_id = _o_.mounts_dye_color_id;
/*   77 */     this.mounts_passive_skill_list = new ArrayList();
/*   78 */     for (xbean.PassiveSkillInfo _v_ : _o_.mounts_passive_skill_list)
/*   79 */       this.mounts_passive_skill_list.add(new PassiveSkillInfo(_v_, this, "mounts_passive_skill_list"));
/*   80 */     this.current_mounts_star_level = _o_.current_mounts_star_level;
/*   81 */     this.current_max_star_num = _o_.current_max_star_num;
/*   82 */     this.current_score = _o_.current_score;
/*   83 */     this.current_ornament_rank = _o_.current_ornament_rank;
/*   84 */     this.protect_pet_expand_size = _o_.protect_pet_expand_size;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   89 */     this.mounts_cfg_id = _o_.mounts_cfg_id;
/*   90 */     this.mounts_rank = _o_.mounts_rank;
/*   91 */     this.mounts_dye_color_id = _o_.mounts_dye_color_id;
/*   92 */     this.mounts_passive_skill_list = new ArrayList();
/*   93 */     for (xbean.PassiveSkillInfo _v_ : _o_.mounts_passive_skill_list)
/*   94 */       this.mounts_passive_skill_list.add(new PassiveSkillInfo(_v_, this, "mounts_passive_skill_list"));
/*   95 */     this.current_mounts_star_level = _o_.current_mounts_star_level;
/*   96 */     this.current_max_star_num = _o_.current_max_star_num;
/*   97 */     this.current_score = _o_.current_score;
/*   98 */     this.current_ornament_rank = _o_.current_ornament_rank;
/*   99 */     this.protect_pet_expand_size = _o_.protect_pet_expand_size;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     _os_.marshal(this.mounts_cfg_id);
/*  107 */     _os_.marshal(this.mounts_rank);
/*  108 */     _os_.marshal(this.mounts_dye_color_id);
/*  109 */     _os_.compact_uint32(this.mounts_passive_skill_list.size());
/*  110 */     for (xbean.PassiveSkillInfo _v_ : this.mounts_passive_skill_list)
/*      */     {
/*  112 */       _v_.marshal(_os_);
/*      */     }
/*  114 */     _os_.marshal(this.current_mounts_star_level);
/*  115 */     _os_.marshal(this.current_max_star_num);
/*  116 */     _os_.marshal(this.current_score);
/*  117 */     _os_.marshal(this.current_ornament_rank);
/*  118 */     _os_.marshal(this.protect_pet_expand_size);
/*  119 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  125 */     _xdb_verify_unsafe_();
/*  126 */     this.mounts_cfg_id = _os_.unmarshal_int();
/*  127 */     this.mounts_rank = _os_.unmarshal_int();
/*  128 */     this.mounts_dye_color_id = _os_.unmarshal_int();
/*  129 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  131 */       xbean.PassiveSkillInfo _v_ = new PassiveSkillInfo(0, this, "mounts_passive_skill_list");
/*  132 */       _v_.unmarshal(_os_);
/*  133 */       this.mounts_passive_skill_list.add(_v_);
/*      */     }
/*  135 */     this.current_mounts_star_level = _os_.unmarshal_int();
/*  136 */     this.current_max_star_num = _os_.unmarshal_int();
/*  137 */     this.current_score = _os_.unmarshal_int();
/*  138 */     this.current_ornament_rank = _os_.unmarshal_int();
/*  139 */     this.protect_pet_expand_size = _os_.unmarshal_int();
/*  140 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  146 */     _xdb_verify_unsafe_();
/*  147 */     int _size_ = 0;
/*  148 */     _size_ += CodedOutputStream.computeInt32Size(1, this.mounts_cfg_id);
/*  149 */     _size_ += CodedOutputStream.computeInt32Size(2, this.mounts_rank);
/*  150 */     _size_ += CodedOutputStream.computeInt32Size(3, this.mounts_dye_color_id);
/*  151 */     for (xbean.PassiveSkillInfo _v_ : this.mounts_passive_skill_list)
/*      */     {
/*  153 */       _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */     }
/*  155 */     _size_ += CodedOutputStream.computeInt32Size(5, this.current_mounts_star_level);
/*  156 */     _size_ += CodedOutputStream.computeInt32Size(6, this.current_max_star_num);
/*  157 */     _size_ += CodedOutputStream.computeInt32Size(7, this.current_score);
/*  158 */     _size_ += CodedOutputStream.computeInt32Size(8, this.current_ornament_rank);
/*  159 */     _size_ += CodedOutputStream.computeInt32Size(9, this.protect_pet_expand_size);
/*  160 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  166 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  169 */       _output_.writeInt32(1, this.mounts_cfg_id);
/*  170 */       _output_.writeInt32(2, this.mounts_rank);
/*  171 */       _output_.writeInt32(3, this.mounts_dye_color_id);
/*  172 */       for (xbean.PassiveSkillInfo _v_ : this.mounts_passive_skill_list)
/*      */       {
/*  174 */         _output_.writeMessage(4, _v_);
/*      */       }
/*  176 */       _output_.writeInt32(5, this.current_mounts_star_level);
/*  177 */       _output_.writeInt32(6, this.current_max_star_num);
/*  178 */       _output_.writeInt32(7, this.current_score);
/*  179 */       _output_.writeInt32(8, this.current_ornament_rank);
/*  180 */       _output_.writeInt32(9, this.protect_pet_expand_size);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  184 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  186 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  192 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  195 */       boolean done = false;
/*  196 */       while (!done)
/*      */       {
/*  198 */         int tag = _input_.readTag();
/*  199 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  203 */           done = true;
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  208 */           this.mounts_cfg_id = _input_.readInt32();
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  213 */           this.mounts_rank = _input_.readInt32();
/*  214 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  218 */           this.mounts_dye_color_id = _input_.readInt32();
/*  219 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  223 */           xbean.PassiveSkillInfo _v_ = new PassiveSkillInfo(0, this, "mounts_passive_skill_list");
/*  224 */           _input_.readMessage(_v_);
/*  225 */           this.mounts_passive_skill_list.add(_v_);
/*  226 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  230 */           this.current_mounts_star_level = _input_.readInt32();
/*  231 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  235 */           this.current_max_star_num = _input_.readInt32();
/*  236 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  240 */           this.current_score = _input_.readInt32();
/*  241 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  245 */           this.current_ornament_rank = _input_.readInt32();
/*  246 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  250 */           this.protect_pet_expand_size = _input_.readInt32();
/*  251 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  255 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  257 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  266 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  270 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  272 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MountsInfo copy()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return new MountsInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MountsInfo toData()
/*      */   {
/*  285 */     _xdb_verify_unsafe_();
/*  286 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MountsInfo toBean()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return new MountsInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MountsInfo toDataIf()
/*      */   {
/*  298 */     _xdb_verify_unsafe_();
/*  299 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MountsInfo toBeanIf()
/*      */   {
/*  304 */     _xdb_verify_unsafe_();
/*  305 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMounts_cfg_id()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return this.mounts_cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMounts_rank()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return this.mounts_rank;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMounts_dye_color_id()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     return this.mounts_dye_color_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.PassiveSkillInfo> getMounts_passive_skill_list()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*  344 */     return Logs.logList(new LogKey(this, "mounts_passive_skill_list"), this.mounts_passive_skill_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.PassiveSkillInfo> getMounts_passive_skill_listAsData()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*      */     
/*  352 */     MountsInfo _o_ = this;
/*  353 */     List<xbean.PassiveSkillInfo> mounts_passive_skill_list = new ArrayList();
/*  354 */     for (xbean.PassiveSkillInfo _v_ : _o_.mounts_passive_skill_list)
/*  355 */       mounts_passive_skill_list.add(new PassiveSkillInfo.Data(_v_));
/*  356 */     return mounts_passive_skill_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_mounts_star_level()
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*  364 */     return this.current_mounts_star_level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_max_star_num()
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     return this.current_max_star_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_score()
/*      */   {
/*  379 */     _xdb_verify_unsafe_();
/*  380 */     return this.current_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_ornament_rank()
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     return this.current_ornament_rank;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getProtect_pet_expand_size()
/*      */   {
/*  395 */     _xdb_verify_unsafe_();
/*  396 */     return this.protect_pet_expand_size;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMounts_cfg_id(int _v_)
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*  404 */     Logs.logIf(new LogKey(this, "mounts_cfg_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  408 */         new LogInt(this, MountsInfo.this.mounts_cfg_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  412 */             MountsInfo.this.mounts_cfg_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  416 */     });
/*  417 */     this.mounts_cfg_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMounts_rank(int _v_)
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*  425 */     Logs.logIf(new LogKey(this, "mounts_rank")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  429 */         new LogInt(this, MountsInfo.this.mounts_rank)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  433 */             MountsInfo.this.mounts_rank = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  437 */     });
/*  438 */     this.mounts_rank = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMounts_dye_color_id(int _v_)
/*      */   {
/*  445 */     _xdb_verify_unsafe_();
/*  446 */     Logs.logIf(new LogKey(this, "mounts_dye_color_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  450 */         new LogInt(this, MountsInfo.this.mounts_dye_color_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  454 */             MountsInfo.this.mounts_dye_color_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  458 */     });
/*  459 */     this.mounts_dye_color_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_mounts_star_level(int _v_)
/*      */   {
/*  466 */     _xdb_verify_unsafe_();
/*  467 */     Logs.logIf(new LogKey(this, "current_mounts_star_level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  471 */         new LogInt(this, MountsInfo.this.current_mounts_star_level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  475 */             MountsInfo.this.current_mounts_star_level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  479 */     });
/*  480 */     this.current_mounts_star_level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_max_star_num(int _v_)
/*      */   {
/*  487 */     _xdb_verify_unsafe_();
/*  488 */     Logs.logIf(new LogKey(this, "current_max_star_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  492 */         new LogInt(this, MountsInfo.this.current_max_star_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  496 */             MountsInfo.this.current_max_star_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  500 */     });
/*  501 */     this.current_max_star_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_score(int _v_)
/*      */   {
/*  508 */     _xdb_verify_unsafe_();
/*  509 */     Logs.logIf(new LogKey(this, "current_score")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  513 */         new LogInt(this, MountsInfo.this.current_score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  517 */             MountsInfo.this.current_score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  521 */     });
/*  522 */     this.current_score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_ornament_rank(int _v_)
/*      */   {
/*  529 */     _xdb_verify_unsafe_();
/*  530 */     Logs.logIf(new LogKey(this, "current_ornament_rank")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  534 */         new LogInt(this, MountsInfo.this.current_ornament_rank)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  538 */             MountsInfo.this.current_ornament_rank = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  542 */     });
/*  543 */     this.current_ornament_rank = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setProtect_pet_expand_size(int _v_)
/*      */   {
/*  550 */     _xdb_verify_unsafe_();
/*  551 */     Logs.logIf(new LogKey(this, "protect_pet_expand_size")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  555 */         new LogInt(this, MountsInfo.this.protect_pet_expand_size)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  559 */             MountsInfo.this.protect_pet_expand_size = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  563 */     });
/*  564 */     this.protect_pet_expand_size = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  570 */     _xdb_verify_unsafe_();
/*  571 */     MountsInfo _o_ = null;
/*  572 */     if ((_o1_ instanceof MountsInfo)) { _o_ = (MountsInfo)_o1_;
/*  573 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  574 */       return false;
/*  575 */     if (this.mounts_cfg_id != _o_.mounts_cfg_id) return false;
/*  576 */     if (this.mounts_rank != _o_.mounts_rank) return false;
/*  577 */     if (this.mounts_dye_color_id != _o_.mounts_dye_color_id) return false;
/*  578 */     if (!this.mounts_passive_skill_list.equals(_o_.mounts_passive_skill_list)) return false;
/*  579 */     if (this.current_mounts_star_level != _o_.current_mounts_star_level) return false;
/*  580 */     if (this.current_max_star_num != _o_.current_max_star_num) return false;
/*  581 */     if (this.current_score != _o_.current_score) return false;
/*  582 */     if (this.current_ornament_rank != _o_.current_ornament_rank) return false;
/*  583 */     if (this.protect_pet_expand_size != _o_.protect_pet_expand_size) return false;
/*  584 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  590 */     _xdb_verify_unsafe_();
/*  591 */     int _h_ = 0;
/*  592 */     _h_ += this.mounts_cfg_id;
/*  593 */     _h_ += this.mounts_rank;
/*  594 */     _h_ += this.mounts_dye_color_id;
/*  595 */     _h_ += this.mounts_passive_skill_list.hashCode();
/*  596 */     _h_ += this.current_mounts_star_level;
/*  597 */     _h_ += this.current_max_star_num;
/*  598 */     _h_ += this.current_score;
/*  599 */     _h_ += this.current_ornament_rank;
/*  600 */     _h_ += this.protect_pet_expand_size;
/*  601 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  607 */     _xdb_verify_unsafe_();
/*  608 */     StringBuilder _sb_ = new StringBuilder();
/*  609 */     _sb_.append("(");
/*  610 */     _sb_.append(this.mounts_cfg_id);
/*  611 */     _sb_.append(",");
/*  612 */     _sb_.append(this.mounts_rank);
/*  613 */     _sb_.append(",");
/*  614 */     _sb_.append(this.mounts_dye_color_id);
/*  615 */     _sb_.append(",");
/*  616 */     _sb_.append(this.mounts_passive_skill_list);
/*  617 */     _sb_.append(",");
/*  618 */     _sb_.append(this.current_mounts_star_level);
/*  619 */     _sb_.append(",");
/*  620 */     _sb_.append(this.current_max_star_num);
/*  621 */     _sb_.append(",");
/*  622 */     _sb_.append(this.current_score);
/*  623 */     _sb_.append(",");
/*  624 */     _sb_.append(this.current_ornament_rank);
/*  625 */     _sb_.append(",");
/*  626 */     _sb_.append(this.protect_pet_expand_size);
/*  627 */     _sb_.append(")");
/*  628 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  634 */     ListenableBean lb = new ListenableBean();
/*  635 */     lb.add(new ListenableChanged().setVarName("mounts_cfg_id"));
/*  636 */     lb.add(new ListenableChanged().setVarName("mounts_rank"));
/*  637 */     lb.add(new ListenableChanged().setVarName("mounts_dye_color_id"));
/*  638 */     lb.add(new ListenableChanged().setVarName("mounts_passive_skill_list"));
/*  639 */     lb.add(new ListenableChanged().setVarName("current_mounts_star_level"));
/*  640 */     lb.add(new ListenableChanged().setVarName("current_max_star_num"));
/*  641 */     lb.add(new ListenableChanged().setVarName("current_score"));
/*  642 */     lb.add(new ListenableChanged().setVarName("current_ornament_rank"));
/*  643 */     lb.add(new ListenableChanged().setVarName("protect_pet_expand_size"));
/*  644 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MountsInfo {
/*      */     private Const() {}
/*      */     
/*      */     MountsInfo nThis() {
/*  651 */       return MountsInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  657 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MountsInfo copy()
/*      */     {
/*  663 */       return MountsInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MountsInfo toData()
/*      */     {
/*  669 */       return MountsInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MountsInfo toBean()
/*      */     {
/*  674 */       return MountsInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MountsInfo toDataIf()
/*      */     {
/*  680 */       return MountsInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MountsInfo toBeanIf()
/*      */     {
/*  685 */       return MountsInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMounts_cfg_id()
/*      */     {
/*  692 */       MountsInfo.this._xdb_verify_unsafe_();
/*  693 */       return MountsInfo.this.mounts_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMounts_rank()
/*      */     {
/*  700 */       MountsInfo.this._xdb_verify_unsafe_();
/*  701 */       return MountsInfo.this.mounts_rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMounts_dye_color_id()
/*      */     {
/*  708 */       MountsInfo.this._xdb_verify_unsafe_();
/*  709 */       return MountsInfo.this.mounts_dye_color_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PassiveSkillInfo> getMounts_passive_skill_list()
/*      */     {
/*  716 */       MountsInfo.this._xdb_verify_unsafe_();
/*  717 */       return xdb.Consts.constList(MountsInfo.this.mounts_passive_skill_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.PassiveSkillInfo> getMounts_passive_skill_listAsData()
/*      */     {
/*  723 */       MountsInfo.this._xdb_verify_unsafe_();
/*      */       
/*  725 */       MountsInfo _o_ = MountsInfo.this;
/*  726 */       List<xbean.PassiveSkillInfo> mounts_passive_skill_list = new ArrayList();
/*  727 */       for (xbean.PassiveSkillInfo _v_ : _o_.mounts_passive_skill_list)
/*  728 */         mounts_passive_skill_list.add(new PassiveSkillInfo.Data(_v_));
/*  729 */       return mounts_passive_skill_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_mounts_star_level()
/*      */     {
/*  736 */       MountsInfo.this._xdb_verify_unsafe_();
/*  737 */       return MountsInfo.this.current_mounts_star_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_max_star_num()
/*      */     {
/*  744 */       MountsInfo.this._xdb_verify_unsafe_();
/*  745 */       return MountsInfo.this.current_max_star_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_score()
/*      */     {
/*  752 */       MountsInfo.this._xdb_verify_unsafe_();
/*  753 */       return MountsInfo.this.current_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_ornament_rank()
/*      */     {
/*  760 */       MountsInfo.this._xdb_verify_unsafe_();
/*  761 */       return MountsInfo.this.current_ornament_rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getProtect_pet_expand_size()
/*      */     {
/*  768 */       MountsInfo.this._xdb_verify_unsafe_();
/*  769 */       return MountsInfo.this.protect_pet_expand_size;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMounts_cfg_id(int _v_)
/*      */     {
/*  776 */       MountsInfo.this._xdb_verify_unsafe_();
/*  777 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMounts_rank(int _v_)
/*      */     {
/*  784 */       MountsInfo.this._xdb_verify_unsafe_();
/*  785 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMounts_dye_color_id(int _v_)
/*      */     {
/*  792 */       MountsInfo.this._xdb_verify_unsafe_();
/*  793 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_mounts_star_level(int _v_)
/*      */     {
/*  800 */       MountsInfo.this._xdb_verify_unsafe_();
/*  801 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_max_star_num(int _v_)
/*      */     {
/*  808 */       MountsInfo.this._xdb_verify_unsafe_();
/*  809 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_score(int _v_)
/*      */     {
/*  816 */       MountsInfo.this._xdb_verify_unsafe_();
/*  817 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_ornament_rank(int _v_)
/*      */     {
/*  824 */       MountsInfo.this._xdb_verify_unsafe_();
/*  825 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setProtect_pet_expand_size(int _v_)
/*      */     {
/*  832 */       MountsInfo.this._xdb_verify_unsafe_();
/*  833 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  839 */       MountsInfo.this._xdb_verify_unsafe_();
/*  840 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  846 */       MountsInfo.this._xdb_verify_unsafe_();
/*  847 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  853 */       return MountsInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  859 */       return MountsInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  865 */       MountsInfo.this._xdb_verify_unsafe_();
/*  866 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  872 */       return MountsInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  878 */       return MountsInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  884 */       MountsInfo.this._xdb_verify_unsafe_();
/*  885 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  891 */       return MountsInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  897 */       return MountsInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  903 */       return MountsInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  909 */       return MountsInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  915 */       return MountsInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  921 */       return MountsInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  927 */       return MountsInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MountsInfo
/*      */   {
/*      */     private int mounts_cfg_id;
/*      */     
/*      */     private int mounts_rank;
/*      */     
/*      */     private int mounts_dye_color_id;
/*      */     
/*      */     private ArrayList<xbean.PassiveSkillInfo> mounts_passive_skill_list;
/*      */     
/*      */     private int current_mounts_star_level;
/*      */     
/*      */     private int current_max_star_num;
/*      */     
/*      */     private int current_score;
/*      */     
/*      */     private int current_ornament_rank;
/*      */     
/*      */     private int protect_pet_expand_size;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  955 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  960 */       this.mounts_passive_skill_list = new ArrayList();
/*  961 */       this.protect_pet_expand_size = 0;
/*      */     }
/*      */     
/*      */     Data(xbean.MountsInfo _o1_)
/*      */     {
/*  966 */       if ((_o1_ instanceof MountsInfo)) { assign((MountsInfo)_o1_);
/*  967 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  968 */       } else if ((_o1_ instanceof MountsInfo.Const)) assign(((MountsInfo.Const)_o1_).nThis()); else {
/*  969 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MountsInfo _o_) {
/*  974 */       this.mounts_cfg_id = _o_.mounts_cfg_id;
/*  975 */       this.mounts_rank = _o_.mounts_rank;
/*  976 */       this.mounts_dye_color_id = _o_.mounts_dye_color_id;
/*  977 */       this.mounts_passive_skill_list = new ArrayList();
/*  978 */       for (xbean.PassiveSkillInfo _v_ : _o_.mounts_passive_skill_list)
/*  979 */         this.mounts_passive_skill_list.add(new PassiveSkillInfo.Data(_v_));
/*  980 */       this.current_mounts_star_level = _o_.current_mounts_star_level;
/*  981 */       this.current_max_star_num = _o_.current_max_star_num;
/*  982 */       this.current_score = _o_.current_score;
/*  983 */       this.current_ornament_rank = _o_.current_ornament_rank;
/*  984 */       this.protect_pet_expand_size = _o_.protect_pet_expand_size;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  989 */       this.mounts_cfg_id = _o_.mounts_cfg_id;
/*  990 */       this.mounts_rank = _o_.mounts_rank;
/*  991 */       this.mounts_dye_color_id = _o_.mounts_dye_color_id;
/*  992 */       this.mounts_passive_skill_list = new ArrayList();
/*  993 */       for (xbean.PassiveSkillInfo _v_ : _o_.mounts_passive_skill_list)
/*  994 */         this.mounts_passive_skill_list.add(new PassiveSkillInfo.Data(_v_));
/*  995 */       this.current_mounts_star_level = _o_.current_mounts_star_level;
/*  996 */       this.current_max_star_num = _o_.current_max_star_num;
/*  997 */       this.current_score = _o_.current_score;
/*  998 */       this.current_ornament_rank = _o_.current_ornament_rank;
/*  999 */       this.protect_pet_expand_size = _o_.protect_pet_expand_size;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1005 */       _os_.marshal(this.mounts_cfg_id);
/* 1006 */       _os_.marshal(this.mounts_rank);
/* 1007 */       _os_.marshal(this.mounts_dye_color_id);
/* 1008 */       _os_.compact_uint32(this.mounts_passive_skill_list.size());
/* 1009 */       for (xbean.PassiveSkillInfo _v_ : this.mounts_passive_skill_list)
/*      */       {
/* 1011 */         _v_.marshal(_os_);
/*      */       }
/* 1013 */       _os_.marshal(this.current_mounts_star_level);
/* 1014 */       _os_.marshal(this.current_max_star_num);
/* 1015 */       _os_.marshal(this.current_score);
/* 1016 */       _os_.marshal(this.current_ornament_rank);
/* 1017 */       _os_.marshal(this.protect_pet_expand_size);
/* 1018 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1024 */       this.mounts_cfg_id = _os_.unmarshal_int();
/* 1025 */       this.mounts_rank = _os_.unmarshal_int();
/* 1026 */       this.mounts_dye_color_id = _os_.unmarshal_int();
/* 1027 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1029 */         xbean.PassiveSkillInfo _v_ = xbean.Pod.newPassiveSkillInfoData();
/* 1030 */         _v_.unmarshal(_os_);
/* 1031 */         this.mounts_passive_skill_list.add(_v_);
/*      */       }
/* 1033 */       this.current_mounts_star_level = _os_.unmarshal_int();
/* 1034 */       this.current_max_star_num = _os_.unmarshal_int();
/* 1035 */       this.current_score = _os_.unmarshal_int();
/* 1036 */       this.current_ornament_rank = _os_.unmarshal_int();
/* 1037 */       this.protect_pet_expand_size = _os_.unmarshal_int();
/* 1038 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1044 */       int _size_ = 0;
/* 1045 */       _size_ += CodedOutputStream.computeInt32Size(1, this.mounts_cfg_id);
/* 1046 */       _size_ += CodedOutputStream.computeInt32Size(2, this.mounts_rank);
/* 1047 */       _size_ += CodedOutputStream.computeInt32Size(3, this.mounts_dye_color_id);
/* 1048 */       for (xbean.PassiveSkillInfo _v_ : this.mounts_passive_skill_list)
/*      */       {
/* 1050 */         _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */       }
/* 1052 */       _size_ += CodedOutputStream.computeInt32Size(5, this.current_mounts_star_level);
/* 1053 */       _size_ += CodedOutputStream.computeInt32Size(6, this.current_max_star_num);
/* 1054 */       _size_ += CodedOutputStream.computeInt32Size(7, this.current_score);
/* 1055 */       _size_ += CodedOutputStream.computeInt32Size(8, this.current_ornament_rank);
/* 1056 */       _size_ += CodedOutputStream.computeInt32Size(9, this.protect_pet_expand_size);
/* 1057 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1065 */         _output_.writeInt32(1, this.mounts_cfg_id);
/* 1066 */         _output_.writeInt32(2, this.mounts_rank);
/* 1067 */         _output_.writeInt32(3, this.mounts_dye_color_id);
/* 1068 */         for (xbean.PassiveSkillInfo _v_ : this.mounts_passive_skill_list)
/*      */         {
/* 1070 */           _output_.writeMessage(4, _v_);
/*      */         }
/* 1072 */         _output_.writeInt32(5, this.current_mounts_star_level);
/* 1073 */         _output_.writeInt32(6, this.current_max_star_num);
/* 1074 */         _output_.writeInt32(7, this.current_score);
/* 1075 */         _output_.writeInt32(8, this.current_ornament_rank);
/* 1076 */         _output_.writeInt32(9, this.protect_pet_expand_size);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1080 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1082 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1090 */         boolean done = false;
/* 1091 */         while (!done)
/*      */         {
/* 1093 */           int tag = _input_.readTag();
/* 1094 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1098 */             done = true;
/* 1099 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1103 */             this.mounts_cfg_id = _input_.readInt32();
/* 1104 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1108 */             this.mounts_rank = _input_.readInt32();
/* 1109 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1113 */             this.mounts_dye_color_id = _input_.readInt32();
/* 1114 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/* 1118 */             xbean.PassiveSkillInfo _v_ = xbean.Pod.newPassiveSkillInfoData();
/* 1119 */             _input_.readMessage(_v_);
/* 1120 */             this.mounts_passive_skill_list.add(_v_);
/* 1121 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1125 */             this.current_mounts_star_level = _input_.readInt32();
/* 1126 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1130 */             this.current_max_star_num = _input_.readInt32();
/* 1131 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1135 */             this.current_score = _input_.readInt32();
/* 1136 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1140 */             this.current_ornament_rank = _input_.readInt32();
/* 1141 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1145 */             this.protect_pet_expand_size = _input_.readInt32();
/* 1146 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1150 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1152 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1161 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1165 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1167 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MountsInfo copy()
/*      */     {
/* 1173 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MountsInfo toData()
/*      */     {
/* 1179 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MountsInfo toBean()
/*      */     {
/* 1184 */       return new MountsInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MountsInfo toDataIf()
/*      */     {
/* 1190 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MountsInfo toBeanIf()
/*      */     {
/* 1195 */       return new MountsInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1201 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1205 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1209 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1213 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1217 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1221 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1225 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMounts_cfg_id()
/*      */     {
/* 1232 */       return this.mounts_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMounts_rank()
/*      */     {
/* 1239 */       return this.mounts_rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMounts_dye_color_id()
/*      */     {
/* 1246 */       return this.mounts_dye_color_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PassiveSkillInfo> getMounts_passive_skill_list()
/*      */     {
/* 1253 */       return this.mounts_passive_skill_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PassiveSkillInfo> getMounts_passive_skill_listAsData()
/*      */     {
/* 1260 */       return this.mounts_passive_skill_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_mounts_star_level()
/*      */     {
/* 1267 */       return this.current_mounts_star_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_max_star_num()
/*      */     {
/* 1274 */       return this.current_max_star_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_score()
/*      */     {
/* 1281 */       return this.current_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_ornament_rank()
/*      */     {
/* 1288 */       return this.current_ornament_rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getProtect_pet_expand_size()
/*      */     {
/* 1295 */       return this.protect_pet_expand_size;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMounts_cfg_id(int _v_)
/*      */     {
/* 1302 */       this.mounts_cfg_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMounts_rank(int _v_)
/*      */     {
/* 1309 */       this.mounts_rank = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMounts_dye_color_id(int _v_)
/*      */     {
/* 1316 */       this.mounts_dye_color_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_mounts_star_level(int _v_)
/*      */     {
/* 1323 */       this.current_mounts_star_level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_max_star_num(int _v_)
/*      */     {
/* 1330 */       this.current_max_star_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_score(int _v_)
/*      */     {
/* 1337 */       this.current_score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_ornament_rank(int _v_)
/*      */     {
/* 1344 */       this.current_ornament_rank = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setProtect_pet_expand_size(int _v_)
/*      */     {
/* 1351 */       this.protect_pet_expand_size = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1357 */       if (!(_o1_ instanceof Data)) return false;
/* 1358 */       Data _o_ = (Data)_o1_;
/* 1359 */       if (this.mounts_cfg_id != _o_.mounts_cfg_id) return false;
/* 1360 */       if (this.mounts_rank != _o_.mounts_rank) return false;
/* 1361 */       if (this.mounts_dye_color_id != _o_.mounts_dye_color_id) return false;
/* 1362 */       if (!this.mounts_passive_skill_list.equals(_o_.mounts_passive_skill_list)) return false;
/* 1363 */       if (this.current_mounts_star_level != _o_.current_mounts_star_level) return false;
/* 1364 */       if (this.current_max_star_num != _o_.current_max_star_num) return false;
/* 1365 */       if (this.current_score != _o_.current_score) return false;
/* 1366 */       if (this.current_ornament_rank != _o_.current_ornament_rank) return false;
/* 1367 */       if (this.protect_pet_expand_size != _o_.protect_pet_expand_size) return false;
/* 1368 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1374 */       int _h_ = 0;
/* 1375 */       _h_ += this.mounts_cfg_id;
/* 1376 */       _h_ += this.mounts_rank;
/* 1377 */       _h_ += this.mounts_dye_color_id;
/* 1378 */       _h_ += this.mounts_passive_skill_list.hashCode();
/* 1379 */       _h_ += this.current_mounts_star_level;
/* 1380 */       _h_ += this.current_max_star_num;
/* 1381 */       _h_ += this.current_score;
/* 1382 */       _h_ += this.current_ornament_rank;
/* 1383 */       _h_ += this.protect_pet_expand_size;
/* 1384 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1390 */       StringBuilder _sb_ = new StringBuilder();
/* 1391 */       _sb_.append("(");
/* 1392 */       _sb_.append(this.mounts_cfg_id);
/* 1393 */       _sb_.append(",");
/* 1394 */       _sb_.append(this.mounts_rank);
/* 1395 */       _sb_.append(",");
/* 1396 */       _sb_.append(this.mounts_dye_color_id);
/* 1397 */       _sb_.append(",");
/* 1398 */       _sb_.append(this.mounts_passive_skill_list);
/* 1399 */       _sb_.append(",");
/* 1400 */       _sb_.append(this.current_mounts_star_level);
/* 1401 */       _sb_.append(",");
/* 1402 */       _sb_.append(this.current_max_star_num);
/* 1403 */       _sb_.append(",");
/* 1404 */       _sb_.append(this.current_score);
/* 1405 */       _sb_.append(",");
/* 1406 */       _sb_.append(this.current_ornament_rank);
/* 1407 */       _sb_.append(",");
/* 1408 */       _sb_.append(this.protect_pet_expand_size);
/* 1409 */       _sb_.append(")");
/* 1410 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MountsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */